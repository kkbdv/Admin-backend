package edu.kkbdv.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.kkbdv.mapper.ForumMapper;
import edu.kkbdv.pojo.Forum;
import edu.kkbdv.service.ForumService;
import edu.kkbdv.utils.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    public ForumMapper forumMapper;

    @Override
    public PagedResult queryForumList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Forum> forums = forumMapper.selectAll();
        PageInfo<Forum> pageInfo = new PageInfo<>(forums);

        PagedResult grid = new PagedResult();
        grid.setTotal(pageInfo.getPages());
        grid.setRows(forums);
        grid.setPage(page);
        grid.setRecords(pageInfo.getTotal());
        return grid;
    }

    @Override
    public void delForum(String id) {
        forumMapper.deleteByPrimaryKey(id);
    }
}
