package com;

import com.model.File;

import java.util.Arrays;
import java.util.List;


public class TestData {

    public static final File FILE1 = new File(null, new byte[]{4, 6, -2, 9, 29, -11, -9, -7, 27});
    public static final File FILE2 = new File(null, new byte[]{4, 6, -2, 9, 29, -11, -9, -7, 27});
    public static final File FILE3 = new File(null, new byte[]{4, 6, -2, 9, 29, -11, -9, -7, 27});
    public static final File FILE4 = new File(null, new byte[]{4, 6, -2, 9, 29, -11, -9, -7, 27});
    public static final File FILE5 = new File(null, new byte[]{4, 6, -2, 9, 29, -11, -9, -7, 27});
    public static final File FILE6 = new File(null, new byte[]{4, 6, -2, 9, 29, -11, -9, -7, 27});

    public static final List<File> TEST_DB = Arrays.asList(FILE1, FILE2, FILE3, FILE4, FILE5, FILE6);
}
