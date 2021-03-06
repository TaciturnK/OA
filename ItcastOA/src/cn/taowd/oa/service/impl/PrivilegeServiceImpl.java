package cn.taowd.oa.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.taowd.oa.base.DaoSupportImpl;
import cn.taowd.oa.domain.Privilege;
import cn.taowd.oa.service.PrivilegeService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {

	public List<Privilege> findTopMenu() {
		return getSession().createQuery("FROM Privilege p WHERE p.parent IS NULL").list();
	}

	/**
	 * 获取所有URL地址
	 */
	public Collection<String> finAllPrivilegeUrls() {

		return getSession().createQuery("SELECT DISTINCT p.url FROM Privilege p where p.url IS NOT NULL")//
				.list();
	}

}
