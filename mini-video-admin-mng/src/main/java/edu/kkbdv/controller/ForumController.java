package edu.kkbdv.controller;

import com.github.pagehelper.PageHelper;
import edu.kkbdv.service.ForumService;
import edu.kkbdv.utils.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    public ForumService forumService;

    @GetMapping("/showForumList")
    public String showForumList(){

        return "forum/forumList";
    }
    @PostMapping("/forumList")
    @ResponseBody
    public PagedResult forumList(Integer page){
        PagedResult pagedResult = forumService.queryForumList(page, 10);
        return pagedResult;
    }

    @PostMapping("/delForum")
    @ResponseBody
    public String delForum(String id){
        forumService.delForum(id);
        return "{code:ok}";
    }
}
