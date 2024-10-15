package com.base.mapper;

import java.util.List;

import com.base.pojo.SysDictType;
import com.base.pojo.SysRole;
import com.base.pojo.SysRole;

public interface SysRoleMapper{

	/**
	 * 根据id数组批量删除数据
	 *
	 * @param array id数组
	 * @return
	 */
	int deletesByPrimaryKey(Long[] array);

	/**
	 * 插入一条数据
	 *
	 * @param t 插入对象
	 * @return
	 */
	int insert(SysRole t);

	/**
	 * 修改一条数据
	 *
	 * @param t 修改对象
	 * @return
	 */
	int updateByPrimaryKey(SysRole t);

	/**
	 * 根据id查看数据
	 *
	 * @param id
	 * @return
	 */
	SysRole selectByPrimaryKey(Long id);

	/**
	 * 查看所有数据，可根据名称进行模糊查询
	 *
	 * @param
	 * @return
	 */
	List<SysRole> selectList(String condition);

	List<SysRole> selectByIds(Long[] array);
}