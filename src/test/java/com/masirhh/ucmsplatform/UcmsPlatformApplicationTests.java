package com.masirhh.ucmsplatform;

import com.masirhh.ucmsplatform.dao.UpCommentDao;
import com.masirhh.ucmsplatform.entity.UpComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UcmsPlatformApplicationTests {
    @Autowired
    private UpCommentDao upCommentDao;

    @Test
    public void test1(){
        List<UpComment> upComments = upCommentDao.selectList(null);
        System.out.println(upComments);

    }


}
