package com.kh.mango.user.store.logic;

import com.kh.mango.message.domain.Message;
import com.kh.mango.point.domain.AdminPoint;
import com.kh.mango.point.domain.PointRecord;
import com.kh.mango.user.domain.*;
import com.kh.mango.user.store.UserStore;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserStoreLogic implements UserStore {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public int insertUser(SqlSession session, User user) {
        int result = session.insert("UserMapper.insertUser", user);
        return result;
    }

    @Override
    public User checkUserLogin(SqlSession session, User user) {
        User uOne = session.selectOne("UserMapper.checkUserLogin", user);
        return uOne;
    }

    @Override
    public User findUserId(SqlSession session, User user) {
        User uOne = session.selectOne("UserMapper.selectFindId", user);
        return uOne;
    }

    @Override
    public User findUserPw(SqlSession session, User user) {
        return sqlSession.selectOne("UserMapper.selectFindPw", user);
    }

    @Override
    public List<User> selectMember() {
        List<User> userList = sqlSession.selectList("UserMapper.test");
        return userList;
    }


    @Override
    public MyPage selectMyPageUser(int userNo) {
        return sqlSession.selectOne("UserMapper.selectUserByMyPage",userNo);
    }


    @Override
    public List<User> searchUser(String searchValue) {
        List<User> searchList = sqlSession.selectList("UserMapper.searchUser", searchValue);
        return searchList;
    }

    @Override
    public List<MyPageFollow> selectMyPageFollower(int userNo) {
        return sqlSession.selectList("UserMapper.selectFollowers",userNo);
    }

    @Override
    public List<MyPageDeals> selectMyPageDeals(int userNo) {
        return sqlSession.selectList("UserMapper.selectDeals", userNo);
    }

    @Override
    public List<Like> selectMyPageLikes(int userNo) {
        return sqlSession.selectList("UserMapper.selectLikes",userNo);
    }

    @Override
    public List<PointRecord> selectPointRecord(int userNo) {
        return sqlSession.selectList("UserMapper.selectPointRecord",userNo);
    }

    @Override
    public int addAllPoint() {
        int result = sqlSession.selectOne("PointMapper.addAllPoint");
        return result;
    }

    @Override
    public int updateUserPw(SqlSession session, User uParam) {
        return session.update("UserMapper.updateUserPw",uParam);
    }

    @Override
    public User selectUserPw(SqlSession session, User uParam) {
        return session.selectOne("UserMapper.selectUserPw",uParam);
    }



    @Override
    public User selectOneByNumber(int userNo) {
        User user = sqlSession.selectOne("UserMapper.selectOneByNumber", userNo);
        return user;
    }
}
