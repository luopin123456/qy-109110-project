package com.aaa.service;

import com.aaa.properties.FtpProperties;
import com.aaa.untils.FtpUtils;
import com.aaa.utils.FileNameUtils;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.aaa.staticproperties.RedisProperties.*;
import static com.aaa.staticproperties.TimeForatProperties.*;

@Service
public class UploadService {
    @Autowired
    private FtpProperties ftpProperties;
    public Boolean upload(MultipartFile file) {
        String oleFilename = file.getOriginalFilename();
        String newFileName = FileNameUtils.getFileName();
        newFileName = newFileName + oleFilename.substring(oleFilename.lastIndexOf(POINT));
        String filePath = DateUtil.formatDate(new Date(), DATE_FORMAT);
        try {
            return FtpUtils.upload(ftpProperties.getHost(), ftpProperties.getPort(), ftpProperties.getUsername(),
                    ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newFileName, file.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
