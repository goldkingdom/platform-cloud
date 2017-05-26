package cn.xj.common.sql.service.impl;

import cn.xj.common.sql.service.SqlService;
import cn.xj.common.sql.service.PagerService;
import cn.xj.common.util.ConvertUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Welink on 2017/2/8.
 */
@Service
public class OrclPagerServiceImpl implements PagerService {

    @Autowired
    private SqlService sqlService;

    @Override
    public List query(StringBuffer sql, Map params, Map pager, String countColumn) {
        if (pager == null) {
            throw new RuntimeException("请输入分页信息");
        }
        String str = sql.toString();
        str = str.toLowerCase().indexOf("order by") > 0 ? str.substring(0, str.toLowerCase().indexOf("order by") - 1) : str;
        //获取分页信息
        String countSql = StringUtils.isEmpty(countColumn) ? str.replace(str.substring(0, str.toLowerCase().indexOf("from")), "select count(*) COUNT ")
                : str.replace(str.substring(0, str.toLowerCase().indexOf("from")), "select count(" + countColumn + ") COUNT ");
        List<Map> countList = sqlService.query(new StringBuffer(countSql), params);
        Integer totalItems;
        if (str.toLowerCase().indexOf("group by") > 0) {
            totalItems = countList == null || countList.size() == 0 ? 0 : countList.size();
        } else {
            totalItems = countList == null || countList.size() == 0 ? 0 : ConvertUtil.objectToInt(countList.get(0).get("COUNT"));
        }
        countSql = null;
        pager.put("totalItems", totalItems);
        pager.put("totalPages", totalItems % ConvertUtil.objectToInt(pager.get("itemsPerPage")) > 0 ? totalItems / ConvertUtil.objectToInt(pager.get("itemsPerPage")) + 1 : totalItems / ConvertUtil.objectToInt(pager.get("itemsPerPage")));
        //根据分页信息进行分页查询
        String pagerSql = "SELECT pager1.* FROM (SELECT pager2.*,rownum AS rowno FROM (" + sql.toString() + ") pager2 where rownum <= {itemsEnd,Integer}) pager1 where pager1.rowno > {itemsStart,Integer}";
        params = params == null ? Maps.newHashMap() : params;
        params.put("itemsEnd", ConvertUtil.objectToInt(pager.get("currentPage")) * ConvertUtil.objectToInt(pager.get("itemsPerPage")));
        params.put("itemsStart", (ConvertUtil.objectToInt(pager.get("currentPage")) - 1) * ConvertUtil.objectToInt(pager.get("itemsPerPage")));
        List<Map> list = sqlService.query(new StringBuffer(pagerSql), params);
        pagerSql = null;
        str = null;
        return list;
    }

}
