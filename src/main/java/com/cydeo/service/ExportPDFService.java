package com.cydeo.service;

import java.io.ByteArrayInputStream;
import java.util.Map;

public interface ExportPDFService {

        ByteArrayInputStream exportReceiptPdf(String templateName, Map<String, Object> data);
    }

