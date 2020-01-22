package com.alex.impl;

import com.alex.api.AdminService;
import com.alex.bean.TAdmin;
import com.alex.bean.TAdminExample;
import com.alex.mapper.TAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    TAdminMapper adminMapper;

    @Override
    public TAdmin login(String name, String password) {

        TAdminExample example = new TAdminExample();
        TAdminExample.Criteria criteria = example.createCriteria();
        criteria.andLoginacctEqualTo(name).andUserpswdEqualTo(password);
        List<TAdmin> admin = adminMapper.selectByExample(example);

        return admin != null && admin.size() == 1 ? admin.get(0) : null;
    }
}
