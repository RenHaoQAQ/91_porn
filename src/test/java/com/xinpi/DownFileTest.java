package com.xinpi;

import com.xinpi.down.DownFileController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * 类 名 称：DownFileTest
 * 类 描 述：TODO
 * 创建时间：2019-08-23 12:59
 * 创 建 人：renhao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DownFileTest {
    @Value("${file.upload.path1}")
    private String path1;
    @Autowired
    private DownFileController downFile;

    @Test
    public void testo1() {
        downFile.getConllection();
    }

    /*这是将文件名入库*/
    @Test
    public void qq() {
        File file = new File(path1);
        String test[];
        test = file.list();
        for (int i = 0; i < test.length; i++) {

        }

    }
}
