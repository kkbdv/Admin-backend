package edu.kkbdv.service;

import edu.kkbdv.pojo.Users;
import edu.kkbdv.utils.PagedResult;

public interface UsersService {

	public PagedResult queryUsers(Users user, Integer page, Integer pageSize);

	public void delUser(String id);
}
