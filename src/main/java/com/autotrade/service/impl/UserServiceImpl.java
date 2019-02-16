package com.autotrade.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autotrade.dao.PopedomDao;
import com.autotrade.dao.UserDao;
import com.autotrade.entity.User;
import com.autotrade.entity.UserPopedom;
import com.autotrade.service.UserService;
import com.autotrade.utils.Md5Util;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private PopedomDao popedomDao;

	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}

	@Override
	@Transactional
	public Integer updateUser(User user) {
		Integer row = -1;
		List<Integer> popedom = new ArrayList<>();
		if (user.getpId() == 2000) {
			user.setPost("总经理");
			user.setKeyWord("generalManager");
		}
		if (user.getpId() == 2001) {
			user.setPost("销售主管");
			user.setKeyWord("salesExecutive");
		}
		if (user.getpId() == 2002) {
			user.setPost("财务主管");
			user.setKeyWord("financialExecutive");
		}
		if (user.getpId() == 2003) {
			user.setPost("维修主管");
			user.setKeyWord("maintenanceSupervisor");
		}
		if (user.getpId() == 2004) {
			user.setPost("采购员");
			user.setKeyWord("purchase");
		}
		if (user.getpId() == 2005) {
			user.setPost("金融主管");
			user.setKeyWord("financialDirector");
		}
		row = popedomDao.deletePopedomById(user.getId());
		if (user.getpId() == 2000) {// 总经理。拥有所有权限
			popedom.add(1001);
			popedom.add(1002);
			popedom.add(1003);
			popedom.add(1004);
			popedom.add(1005);
			popedom.add(1006);
			popedom.add(1007);
			popedom.add(1008);
			popedom.add(1009);
			popedom.add(1010);
			popedom.add(1011);
			popedom.add(1012);
			popedom.add(1013);
			popedom.add(1014);
			popedom.add(1015);
			popedom.add(1016);
			popedom.add(1017);
			popedom.add(1018);
			popedom.add(1019);
			popedom.add(1020);
			popedom.add(1021);
			popedom.add(1022);
			popedom.add(1023);
			popedom.add(1024);
			popedom.add(1025);
			popedom.add(1026);
			popedom.add(1027);
			popedom.add(1028);
			popedom.add(1029);
			popedom.add(1030);
		}
		if (user.getpId() == 2001) {// 销售主管
			popedom.add(1001);// 车辆资源
			popedom.add(1002);// 买车咨询
			popedom.add(1003);// 车辆置换
			popedom.add(1007);// 订车管理
			popedom.add(1008);// 售车管理
			popedom.add(1009);// 推车管理
		}
		if (user.getpId() == 2002) {// 财务主管
			popedom.add(1011);// 收入管理
			popedom.add(1012);// 支出管理
			popedom.add(1013);// 部门管理
		}
		if (user.getpId() == 2003) {// 维修主管
			popedom.add(1018);// 维修工单
			popedom.add(1019);// 维修车型分类
			popedom.add(1020);// 维修工时计算
			popedom.add(1021);// 维修项目定义
			popedom.add(1022);// 维修项目用料
		}
		if (user.getpId() == 2004) {// 采购
			popedom.add(1014);// 汽车配件
			popedom.add(1015);// 其他
		}
		if (user.getpId() == 2005) {// 金融主管
			popedom.add(1004);// 评估审核
			popedom.add(1005);// 保险凭证
			popedom.add(1006);// 分期管理
		}
		for (Integer p : popedom) {
			// 创建用户权限对象，设置默认权限用
			UserPopedom userPopedom = new UserPopedom();
			userPopedom.setId(null);
			userPopedom.setpId(p);
			userPopedom.setUserId(user.getId());
			userPopedom.setUpdateTime(new Date());
			popedomDao.addPopedomById(userPopedom);
		}
		if (user.getPassWord() != null && user.getPassWord() != "") {
			String passWord = Md5Util.md5(user.getPassWord(), user.getUserName());
			user.setPassWord(passWord);
		} else {
			user.setPassWord(null);
		}
		user.setUpdateTime(new Date());
		row = userDao.updateUserById(user);
		return row;
	}

	@Override
	@Transactional
	public Integer insertUser(User user) {
		Date date = new Date();
		Integer row = -1;
		// 判断此用户名是否可用
		if (findUserByUserName(user.getUserName()) == null) {// 次用户名可用
			List<Integer> popedom = new ArrayList<>();
			// 对应Shiro框架密码加密，将密码进行加密
			String passWord = Md5Util.md5(user.getPassWord(), user.getUserName());
			user.setPassWord(passWord);
			user.setCreateTime(date);
			user.setUpdateTime(date);
			user.setStatus(1);
			if (user.getpId() == 2000) {
				user.setPost("总经理");
				user.setKeyWord("generalManager");
			}
			if (user.getpId() == 2001) {
				user.setPost("销售主管");
				user.setKeyWord("salesExecutive");
			}
			if (user.getpId() == 2002) {
				user.setPost("财务主管");
				user.setKeyWord("financialExecutive");
			}
			if (user.getpId() == 2003) {
				user.setPost("维修主管");
				user.setKeyWord("maintenanceSupervisor");
			}
			if (user.getpId() == 2004) {
				user.setPost("采购员");
				user.setKeyWord("purchase");
			}
			if (user.getpId() == 2005) {
				user.setPost("金融主管");
				user.setKeyWord("financialDirector");
			}
			System.out.println("桩:   " + user);
			row = userDao.insert(user);
			if (row > 0) {
				User u = userDao.findUserByUserName(user.getUserName());
				System.out.println("user2 : " + u.toString());
				if (u != null) {
					if (u.getpId() == 2000) {// 总经理。拥有所有权限
						popedom.add(1001);
						popedom.add(1002);
						popedom.add(1003);
						popedom.add(1004);
						popedom.add(1005);
						popedom.add(1006);
						popedom.add(1007);
						popedom.add(1008);
						popedom.add(1009);
						popedom.add(1010);
						popedom.add(1011);
						popedom.add(1012);
						popedom.add(1013);
						popedom.add(1014);
						popedom.add(1015);
						popedom.add(1016);
						popedom.add(1017);
						popedom.add(1018);
						popedom.add(1019);
						popedom.add(1020);
						popedom.add(1021);
						popedom.add(1022);
						popedom.add(1023);
						popedom.add(1024);
						popedom.add(1025);
						popedom.add(1026);
						popedom.add(1027);
						popedom.add(1028);
						popedom.add(1029);
						popedom.add(1030);
					}
					if (u.getpId() == 2001) {// 销售主管
						popedom.add(1001);// 车辆资源
						popedom.add(1002);// 买车咨询
						popedom.add(1003);// 车辆置换
						popedom.add(1007);// 订车管理
						popedom.add(1008);// 售车管理
						popedom.add(1009);// 推车管理
					}
					if (u.getpId() == 2002) {// 财务主管
						popedom.add(1011);// 收入管理
						popedom.add(1012);// 支出管理
						popedom.add(1013);// 部门管理
					}
					if (u.getpId() == 2003) {// 维修主管
						popedom.add(1018);// 维修工单
						popedom.add(1019);// 维修车型分类
						popedom.add(1020);// 维修工时计算
						popedom.add(1021);// 维修项目定义
						popedom.add(1022);// 维修项目用料
					}
					if (u.getpId() == 2004) {// 采购
						popedom.add(1014);// 汽车配件
						popedom.add(1015);// 其他
					}
					if (u.getpId() == 2005) {// 金融主管
						popedom.add(1004);// 评估审核
						popedom.add(1005);// 保险凭证
						popedom.add(1006);// 分期管理
					}
				}

				for (Integer p : popedom) {
					// 创建用户权限对象，设置默认权限用
					UserPopedom userPopedom = new UserPopedom();
					userPopedom.setId(null);
					userPopedom.setpId(p);
					userPopedom.setUserId(u.getId());
					userPopedom.setUpdateTime(new Date());
					popedomDao.addPopedomById(userPopedom);
				}
			}
			return row;
		} else {
			return row;
		}
	}

	@Override
	public List<User> findByLimit(Integer page, Integer limit) {
		return userDao.findByLimit(page, limit);
	}

	@Override
	public Integer findAllCount() {
		return userDao.findAllCount();
	}

	@Override
	public User findById(Long id) {
		return userDao.findbyId(id);
	}

}
