package edu.kkbdv.service;

import edu.kkbdv.utils.PagedResult;

public interface ForumService {

    public PagedResult queryForumList(Integer page, Integer pageSize);

    public void delForum(String id);
}
