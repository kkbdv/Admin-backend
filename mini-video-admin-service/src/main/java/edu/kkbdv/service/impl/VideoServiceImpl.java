package edu.kkbdv.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.kkbdv.enums.BGMOperatorTypeEnum;
import edu.kkbdv.mapper.BgmMapper;
import edu.kkbdv.mapper.UsersReportMapperCustom;
import edu.kkbdv.mapper.VideosMapper;
import edu.kkbdv.pojo.Bgm;
import edu.kkbdv.pojo.BgmExample;
import edu.kkbdv.pojo.Videos;
import edu.kkbdv.pojo.vo.Reports;
import edu.kkbdv.service.VideoService;
import edu.kkbdv.utils.JsonUtils;
import edu.kkbdv.utils.PagedResult;
import edu.kkbdv.web.util.ZKCurator;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideosMapper videosMapper;
		
	@Autowired
	private BgmMapper bgmMapper;
	
	@Autowired
	private Sid sid;
	
//	@Autowired
//	private ZKCurator zkCurator;
	
	@Autowired
	private UsersReportMapperCustom usersReportMapperCustom;
	
	@Override
	public PagedResult queryReportList(Integer page, Integer pageSize) {

		PageHelper.startPage(page, pageSize);

		List<Reports> reportsList = usersReportMapperCustom.selectAllVideoReport();

		PageInfo<Reports> pageList = new PageInfo<Reports>(reportsList);

		PagedResult grid = new PagedResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(reportsList);
		grid.setPage(page);
		grid.setRecords(pageList.getTotal());

		return grid;
	}

	@Override
	public void updateVideoStatus(String videoId, Integer status) {
		
		Videos video = new Videos();
		video.setId(videoId);
		video.setStatus(status);
		videosMapper.updateByPrimaryKeySelective(video);
	}

	@Override
	public PagedResult queryBgmList(Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		
		BgmExample example = new BgmExample();
		List<Bgm> list = bgmMapper.selectByExample(example);
		
		PageInfo<Bgm> pageList = new PageInfo<>(list);
		
		PagedResult result = new PagedResult();
		result.setTotal(pageList.getPages());
		result.setRows(list);
		result.setPage(page);
		result.setRecords(pageList.getTotal());
		
		return result;
	}

	@Override
	public void addBgm(Bgm bgm) {
		String bgmId = sid.nextShort();
		bgm.setId(bgmId);
		bgmMapper.insert(bgm);
		
		Map<String, String> map = new HashMap<>();
		map.put("operType", BGMOperatorTypeEnum.ADD.type);
		map.put("path", bgm.getPath());
		
//		zkCurator.sendBgmOperator(bgmId, JsonUtils.objectToJson(map));
	}
	
	@Override
	public void deleteBgm(String id) {
		Bgm bgm = bgmMapper.selectByPrimaryKey(id);
		
		bgmMapper.deleteByPrimaryKey(id);
		
		Map<String, String> map = new HashMap<>();
		map.put("operType", BGMOperatorTypeEnum.DELETE.type);
		map.put("path", bgm.getPath());
		
//		zkCurator.sendBgmOperator(id, JsonUtils.objectToJson(map));
		
	}

	@Override
	public void delVideo(String id) {
		delLocal(id);
		videosMapper.deleteByPrimaryKey(id);
	}

	private void delLocal(String id){
		Videos videos = videosMapper.selectByPrimaryKey(id);

		String localFile = "G:/kkbdv_dev";
		File file = new File(localFile+videos.getCoverPath());
		File file1 = new File(localFile+videos.getVideoPath());
		//删除
		if(file.exists()){
			file.delete();
		}
		if(file1.exists()){
			file.delete();
		}
	}

	public void delReport(String id){
		usersReportMapperCustom.deleteByPrimaryKey(id);
	}
}
