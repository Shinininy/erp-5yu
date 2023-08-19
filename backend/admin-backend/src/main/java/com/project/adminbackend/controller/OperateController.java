package com.project.adminbackend.controller;

import com.project.adminbackend.dao.InvoiceMapper;
import com.project.adminbackend.pojo.*;
import com.project.adminbackend.pojo.request.*;
import com.project.adminbackend.service.impl.OperateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
// 这里设置允许同源策略, 允许"http://localhost:8080/"这个地址访问接口
@CrossOrigin(originPatterns = {"*"}, allowCredentials = "true")
@RequestMapping("/operates")
public class OperateController {

    @Resource
    private OperateService operateService;

    @Resource
    private InvoiceMapper invoiceMapper;

    /**
     * 得到全部的material
     *
     * @return 使用Result封装结果为JSON风格的数据, 返回数据格式为一个列表, 其包含了全部的Material数据
     */
    @GetMapping("/material/all")
    public Result getAllMaterial() {
        List<Material> res = operateService.getAllMaterial();
        return new Result(Code.OK.getCode(), res);
    }

    /**
     * 得到符合条件的库存stock
     *
     * @param stockQueryParam: 封装了请求参数的对象
     * @return
     */
    @PostMapping("/stock/query")
    public Result queryStock(@RequestBody StockQueryParam stockQueryParam) {
        List<Map<String, Object>> res = operateService.queryStock(stockQueryParam);
        if (res == null) {
            return new Result(Code.OK.getCode(), new ArrayList());
        }
        return new Result(Code.OK.getCode(), res);
    }

    /**
     * 得到符合条件的customer
     *
     * @return
     */
    @PostMapping("/customer/query")
    public Result queryCustomer(@RequestBody CustomerQueryParam customerQueryParam) {
        List<Customer> res = operateService.queryCustomer(customerQueryParam);
        return new Result(Code.OK.getCode(), res);
    }

    /**
     * 根据订单的id得到相对应的详细信息
     *
     * @param idQueryParam
     * @return
     */
    @PostMapping("/salesOrder/query")
    public Result querySalesOrder(@RequestBody IdQueryParam idQueryParam) {
        Map<String, Object> res = operateService.querySalesOrder(idQueryParam);
        return new Result(Code.OK.getCode(), res);
    }

    /**
     * 根据查询参数得到相应的订单信息
     *
     * @param
     * @return
     */
    @PostMapping("/salesOrder/condition")
    public Result querySalesOrderByCondition(@RequestBody OrderQueryParam orderQueryParam) {
        List<Map<String, Object>> res = operateService.querySalesOrderByCondition(orderQueryParam);
        return new Result(Code.OK.getCode(), res);
    }

    /**
     * 根据订单的id来开发票
     *
     * @param idQueryParam
     * @return
     */
    @PostMapping("/invoice/add")
    public Result addInvoice(@RequestBody IdQueryParam idQueryParam) {
        Integer res = operateService.addInvoice(idQueryParam);
        if (res == null) {
            return new Result(Code.BAD_REQUEST.getCode(), "发票信息已经存在");
        }
        return new Result(Code.OK.getCode(), res);
    }

    /**
     * 根据查询条件返回符合条件的invoice信息
     *
     * @param invoiceQueryParam
     * @return
     */
    @PostMapping("/invoice/query")
    public Result queryInvoice(@RequestBody InvoiceQueryParam invoiceQueryParam) {
        List<Map<String, Object>> res = operateService.queryInvoice(invoiceQueryParam);
        return new Result(Code.OK.getCode(), res);
    }

    /**
     * 根据发票的id得到相对应的详细信息
     *
     * @param idQueryParam
     * @return
     */
    @PostMapping("/invoice/query/id")
    public Result queryInvoiceInfoById(@RequestBody IdQueryParam idQueryParam) {
        Invoice invoice = invoiceMapper.selectById(idQueryParam.getId());
        idQueryParam.setId(invoice.getOrderId());
        Map<String, Object> res = operateService.querySalesOrder(idQueryParam);
        return new Result(Code.OK.getCode(), res);
    }
}
