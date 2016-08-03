package com.yulei.demo.controller;

import com.yulei.demo.config.Result;
import com.yulei.demo.model.User;
import com.yulei.demo.model.ViewFinder;
import com.yulei.demo.repository.ViewFinderRepository;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static com.yulei.demo.BaseEntity.UNDELETED;
import static com.yulei.demo.controller.ShiroController.getSession;

/**
 * Created by lei.yu on 2016/4/22.
 */
@Controller
@RequestMapping("view")
public class ViewFinderController {
    @Autowired
    private ViewFinderRepository viewFinderRepository;
@Autowired
private Result result;
    @RequiresPermissions("view:addView")
    @RequestMapping("addView")
    public String addView(Model model){
        List<ViewFinder> firstTypeList = viewFinderRepository.findAllByParentIdAndDeleted(0L,UNDELETED);
        model.addAttribute("firstTypeList",firstTypeList);
        return "/admin/addViewHtml";
    }
    @RequestMapping("saveViewFinder")
    @RequiresPermissions("view:addView")
    @ResponseBody
    public Result saveViewFinder(ViewFinder viewFinder){
        viewFinder.setCreatedAt(new Date());
        viewFinder.setCreatedBy(((User)getSession().getAttribute("user")).getId());
        viewFinder.setDeleted(UNDELETED);
        result.setStatus(viewFinderRepository.save(viewFinder)!=null?1:0);
        return result;
    }
    @RequestMapping("toViewList")
    @RequiresPermissions("view:changeView")
    @ResponseBody
    public String toViewList(Model model){

        return "/admin/viewListHtml";
    }

    /**
     * 根据父标题的id查询所有标题
     * @param parentId
     * @return
     */
    @RequestMapping("getViewByParentId")
    @ResponseBody
    public List<ViewFinder> findViewByParentId(Long parentId){
        return viewFinderRepository.findAllByParentIdAndDeleted(parentId,UNDELETED);
    }
}
