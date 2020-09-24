package com.targetmol.products.dao;

import com.targetmol.products.domain.Product;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface ProductsDao extends BaseMapper<Product> {

    @Select("SELECT [CAS] FROM [tsweb].[dbo].[Cpd_Basic] as a  left join Prod_Arrange as aa on a.tID = aa.tID and aa.Area = 'CN'  where cas is not null and cas <> 'NA' order by cas")
    List<String> findAllCas();
    @Select("SELECT [CAS] as casNo\n" +
            "      ,[name] as casName\n" +
            "    ,'targetmol' as brand\n" +
            "      ,a.[tID] as code\n" +
            "    ,price\n" +
            "    ,1 as quantity\n" +
            "    ,'上海' as warehouse\n" +
            "    ,purity_text as pureness\n" +
            "    ,Spec\n" +
            "    ,cast(left(Spec, CHARINDEX(' ', Spec) - 1) as int) AS packSize\n" +
            "    ,substring(Spec, CHARINDEX(' ', Spec) + 1 , len(Spec) -  CHARINDEX(' ', Spec)) AS packUnit\n" +
            "    ,'件' as packMode\n" +
            "    ,iif(b.[Description] = '上海现货', 1, 0) as isHave\n" +
            "    ,'https://www.tsbiochem.com/compound/' + urid as [url]\n" +
            "  FROM [tsweb].[dbo].[Cpd_Basic] as a \n" +
            "  left join Prod_Arrange as aa on a.tID = aa.tID and aa.Area = 'CN'\n" +
            "  left join Prod_Items as b on a.tID = b.tID\n" +
            "  left join \n" +
            "  (SELECT [cpdID] ,max(purity_text) as purity_text\n" +
            "  FROM [tsweb].[dbo].[QC_Purity]\n" +
            "  group by cpdID) as c on a.cpdID = c.cpdID\n" +
            "  where (aa.onShelf = 1 or aa.onShelf is null) and\n" +
            "  b.onShelf = 1 and b.Area = 'CN' and CAS = #{casno}")
    List<Product> findByCasNo(String casno);
}
