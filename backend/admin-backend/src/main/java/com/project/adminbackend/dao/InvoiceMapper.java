package com.project.adminbackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.adminbackend.pojo.Invoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author w
 * @since 2023-07-13
 */
@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {

    List<Integer> queryInvoiceId(@Param("soldToParty") Integer soldToParty, @Param("billingDate") String billingDate, @Param("salesOrganization") String salesOrganization, @Param("distributionChannel") String distributionChannel);
}
