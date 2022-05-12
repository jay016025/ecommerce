package idv.jay.ecommerce.order.repo;

import idv.jay.ecommerce.order.dto.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommodityMapper {

    @Select("select * from Commodities")
    List<Commodity> selectAll();


}
