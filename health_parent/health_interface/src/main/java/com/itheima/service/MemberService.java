package com.itheima.service;

import com.itheima.pojo.Member;

import java.util.List;

/**
 * @author Helay
 * @date 2020/2/13 21:38
 */
public interface MemberService {

    //根据手机号查询会员
    Member findByTelephone(String telephone);

    //新增会员
    void add(Member member);

    //根据月份查询当月会员数量
    List<Integer> findMemberCountByMonth(List<String> months);

}
