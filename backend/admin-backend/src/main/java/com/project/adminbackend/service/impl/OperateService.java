package com.project.adminbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.adminbackend.dao.*;
import com.project.adminbackend.pojo.*;
import com.project.adminbackend.pojo.request.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OperateService {
    @Resource
    private MaterialMapper materialMapper;

    @Resource
    private StockMapper stockMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private DetailsMapper detailsMapper;

    @Resource
    private SalesOrderMapper salesOrderMapper;

    @Resource
    private InvoiceMapper invoiceMapper;

    /**
     * 得到全部的material
     * @return
     */
    public List<Material> getAllMaterial() {
        return materialMapper.selectList(null);
    }

    /**
     * 得到符合条件的库存信息stock
     * @param stockQueryParam
     * @return
     */
    public List<Map<String, Object>> queryStock(StockQueryParam stockQueryParam) {
        // 对前端传过来的数据进行处理
        Integer materialId = stockQueryParam.getMaterialId();
        Integer plantId = stockQueryParam.getPlantId();
        String storageLocation = stockQueryParam.getStorageLocation();
        // 储存符合条件的stock的id列表
        List<Integer> stockList = new ArrayList<>();
        if (isEmpty(storageLocation)) {
            storageLocation = null;
        }
        // 如果前端传过来的请求参数全为空, 则直接返回一个null, 代表查询不到对应的stock
        if (isEmpty(materialId) && isEmpty(storageLocation) && isEmpty(plantId)) {
            return null;
        }
        // 开始根据数据是否为null来选择不同的mapper接口
        if (!isEmpty(plantId)) {
            stockList = stockMapper.queryStockId(materialId, plantId, storageLocation);
        } else {
            if (isEmpty(materialId)) {
                stockList = stockMapper.queryStockByStorageLocation(storageLocation);
            } else {
                if (isEmpty(storageLocation)) {
                    stockList = stockMapper.queryStockByMaterialId(materialId);
                } else {
                    stockList = stockMapper.queryStockByStorageLocationAndMaterialId(storageLocation, materialId);
                }
            }
        }
        if (stockList.size() == 0) {
            return null;
        }
         // 返回查询到的stock的详细信息
        return stockMapper.queryStockInfo(stockList);
    }

    /**
     * 得到符合条件的customer信息
     * @param customerQueryParam
     * @return
     */
    public List<Customer> queryCustomer(CustomerQueryParam customerQueryParam) {
        // 开始构建查询条件
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        // 如果查询条件全为空则返回一个空的结果
        if (isEmpty(customerQueryParam.getName()) && isEmpty(customerQueryParam.getCity()) && isEmpty(customerQueryParam.getCountry())) {
            return new ArrayList<>();
        }
        if (!isEmpty(customerQueryParam.getCountry())) {
            queryWrapper.eq("country", customerQueryParam.getCountry());
        }
        if (!isEmpty(customerQueryParam.getCity())) {
            queryWrapper.eq("city", customerQueryParam.getCity());
        }
        if (!isEmpty(customerQueryParam.getName())) {
            queryWrapper.eq("name", customerQueryParam.getName());
        }
        // 开始查询符合条件的customer对象
        return customerMapper.selectList(queryWrapper);
    }

    /**
     * 根据订单的id得到相对应的详细信息
     * @param idQueryParam
     * @return
     */
    public Map<String, Object> querySalesOrder(IdQueryParam idQueryParam) {
        Map<String, Object> res = new HashMap<>();
        Integer orderId = idQueryParam.getId();
        QueryWrapper<Details> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        // 得到全部的details信息
        List<Details> detailsList = detailsMapper.selectList(queryWrapper);
        List<Map<String, Object>> materialList = new ArrayList<>();
        for (Details detail : detailsList) {
            Map<String, Object> m = new HashMap<>();
            // 得到detail关联的material信息
            Material material = materialMapper.selectById(detail.getMaterialId());
            // 将数据封装到一个map中
            m.put("materialId", material.getMaterialId());
            m.put("materialName", material.getName());
            m.put("quantity", detail.getQuantity());
            materialList.add(m);
        }
        res.put("materials", materialList);
        Map<String, Object> orderInfo = new HashMap<>();
        // 得到对应的订单信息
        SalesOrder salesOrder = salesOrderMapper.selectById(orderId);
        // 根据订单信息得到对应的客户信息
        Customer customer = customerMapper.selectById(salesOrder.getSoldToParty());
        // 再开始将信息存放到orderInfo中
        orderInfo.put("customerAllInfo", customer);
        orderInfo.put("salesOrderAllInfo", salesOrder);
        res.put("orderInfo", orderInfo);
        return res;
    }


    /**
     * 根据查询参数得到相应的订单信息
     *
     * @param
     * @return
     */
    public List<Map<String, Object>> querySalesOrderByCondition(OrderQueryParam orderQueryParam) {
        List<Map<String, Object>> res = new ArrayList<>();
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        // 构建查询条件
        if (!isEmpty(orderQueryParam.getSoldToParty())) {
            queryWrapper.eq("customer_id", orderQueryParam.getSoldToParty());
        }
        if (!isEmpty(orderQueryParam.getDistributionChannel())) {
            queryWrapper.eq("distr_channel", orderQueryParam.getDistributionChannel());
        }
        if (!isEmpty(orderQueryParam.getSalesOrganization())) {
            queryWrapper.eq("sales_org", orderQueryParam.getSalesOrganization());
        }
        List<Customer> customers = customerMapper.selectList(queryWrapper);
        // 开始封装数据
        for (Customer customer : customers) {
            QueryWrapper<SalesOrder> salesOrderQueryWrapper = new QueryWrapper<>();
            salesOrderQueryWrapper.eq("sold_to_party", customer.getCustomerId());
            List<SalesOrder> salesOrders = salesOrderMapper.selectList(salesOrderQueryWrapper);
            for (SalesOrder order : salesOrders) {
                QueryWrapper<Invoice> invoiceQueryWrapper = new QueryWrapper<>();
                invoiceQueryWrapper.eq("order_id", order.getOrderId());
                Invoice exist = invoiceMapper.selectOne(invoiceQueryWrapper);
                if (exist != null) {
                    continue;
                }
                Map<String, Object> m = new HashMap<>();
                m.put("orderId", order.getOrderId());
                m.put("netValue", order.getNetValue());
                m.put("currency", order.getCurrency());
                m.put("customer", customer);
                res.add(m);
            }
        }
        return res;
    }

    /**
     * 增加订单数据
     * @param idQueryParam
     * @return
     */
    public Integer addInvoice(IdQueryParam idQueryParam) {
        Integer orderId = idQueryParam.getId();
        // 在插入发票信息之前再去数据库中查询是否给该订单开过发票
        QueryWrapper<Invoice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        Invoice exist = invoiceMapper.selectOne(queryWrapper);
        if (exist != null) {
            return null;
        }
        Invoice invoice = new Invoice();
        // 得到对应的订单信息
        SalesOrder salesOrder = salesOrderMapper.selectById(orderId);
        // 根据订单信息得到对应的客户信息
        Customer customer = customerMapper.selectById(salesOrder.getSoldToParty());
        invoice.setCustomerName(customer.getName());
        invoice.setBillingDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        invoice.setShipToParty(salesOrder.getShipToParty());
        invoice.setSoldToParty(salesOrder.getSoldToParty());
        invoice.setNetValue(salesOrder.getNetValue());
        invoice.setCurrency(salesOrder.getCurrency());
        invoice.setOrderId(orderId);
        // 插入到数据库
        invoiceMapper.insert(invoice);
        // 再更新order的invoiceId
        salesOrder.setInvoiceId(invoice.getInvoiceId());
        salesOrderMapper.updateById(salesOrder);
        // 返回发票的id
        return invoice.getInvoiceId();
    }

    /**
     * 根据查询条件返回符合条件的invoice信息
     * @param queryParam
     * @return
     */
    public List<Map<String, Object>> queryInvoice(InvoiceQueryParam queryParam) {
        // 处理一下查询的参数结果
        Integer soldToParty = queryParam.getSoldToParty();
        String salesOrganization = queryParam.getSalesOrganization();
        String distributionChannel = queryParam.getDistributionChannel();
        String billingDate = queryParam.getBillingDate();
        if (isEmpty(salesOrganization)) {
            salesOrganization = null;
        }
        if (isEmpty(distributionChannel)) {
            distributionChannel = null;
        }
        if (isEmpty(billingDate)) {
            billingDate = null;
        }
        // 如果条件为空则直接返回一个空列表
        if (isEmpty(soldToParty) && isEmpty(salesOrganization) && isEmpty(distributionChannel) && isEmpty(billingDate)) {
            return new ArrayList<>();
        }
        // 得到全部的符合条件的invoice的id列表
        List<Integer> idList = invoiceMapper.queryInvoiceId(soldToParty, billingDate, salesOrganization, distributionChannel);
        List<Map<String, Object>> res = new ArrayList<>();
        // 根据invoice的列表去得到对应的相关信息
        for (Integer id : idList) {
            if (id == null) {
                continue;
            }
            System.out.println(idList);
            Map<String, Object> m = new HashMap<>();
            Invoice invoice = invoiceMapper.selectById(id);
            m.put("billingDate", invoice.getBillingDate());
            m.put("invoiceId", invoice.getInvoiceId());
            m.put("soldToParty", invoice.getSoldToParty());
            m.put("payer", invoice.getSoldToParty());
            Customer customer = customerMapper.selectById(invoice.getSoldToParty());
            m.put("salesOrganization", customer.getSalesOrg());
            m.put("distributionChannel", customer.getDistrChannel());
            res.add(m);
        }
        return res;
    }


    private Boolean isEmpty(Integer i) {
        return i == null;
    }

    private Boolean isEmpty(String i) {
        return i == null || "".equals(i);
    }
}
