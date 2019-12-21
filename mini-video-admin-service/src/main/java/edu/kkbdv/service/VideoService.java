package edu.kkbdv.service;

import edu.kkbdv.pojo.Bgm;
import edu.kkbdv.utils.PagedResult;

public interface VideoService {

	public void addBgm(Bgm bgm);
	
	public PagedResult queryBgmList(Integer page, Integer pageSize);
	
	public void deleteBgm(String id);
	
	public PagedResult queryReportList(Integer page, Integer pageSize);
	
	public void updateVideoStatus(String videoId, Integer status);

	/**
	 * 删除视频
	 * @param id
	 */
	public void delVideo(String id);

	public void delReport(String id);
}
