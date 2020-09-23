package com.targetmol.products.dao;

import com.targetmol.products.domain.Product;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface ProductsDao extends BaseMapper<Product> {

    @Select("SELECT [CAS]\n" +
            "  FROM [tsweb].[dbo].[Cpd_Basic] as a \n" +
            "  left join Prod_Arrange as aa on a.tID = aa.tID and aa.Area = 'CN'\n" +
            "  where cas is not null and cas <> 'NA'\n" +
            "  order by cas")
    List<String> findAllCas();

}
