package com.utils;

import java.io.*;

/**
 * Created by wxmimperio on 2016/6/1.
 * 读取指定文件内容，每输出10个bytes，换行
 */
public class IOUtils {
    /**
     * FileInputStream文件输入流
     * 单字节读取（读取较小文件）
     *
     * @param fileName
     */
    public static void printHex(String fileName) {
        FileInputStream in = null;
        int b;
        int i = 1;

        try {
            in = new FileInputStream(fileName);

            //-1表示文件结尾
            while ((b = in.read()) != -1) {
                //单位数前面补0
                if (b <= 0xff) {
                    System.out.print("0");
                }
                //转成16进制
                System.out.print(Integer.toHexString(b & 0xff) + " ");

                if (i++ % 10 == 0) {
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.FileInputStreamClose(in);
        }
    }

    /**
     * FileInputStream文件输入流
     * 批量字节读取（读取较大文件）【常用】
     *
     * @param fileName
     */
    public static byte[] printHexByByteArrays(String fileName) {
        FileInputStream in = null;
        byte[] buf = new byte[10 * 1024];

        int bytes;
        int j = 1;

        try {
            in = new FileInputStream(fileName);

            while ((bytes = in.read(buf, 0, buf.length)) != -1) {
                for (int i = 0; i < bytes; i++) {
                    System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
                    if (j++ % 10 == 0) {
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.FileInputStreamClose(in);
        }
        return buf;
    }

    /**
     * 批量写文件
     *
     * @param fileName
     * @param bytes
     * @param off
     * @param length
     */
    public static void writeHexByByteArrays(String fileName, byte[] bytes, int off, int length) {
        FileOutputStream out = null;
        byte[] buf = new byte[10 * 1024];

        try {
            //写入文件,true表示向后追加
            //如果文件不存在将会创建
            out = new FileOutputStream(fileName, true);
            out.write(bytes, off, length);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.FileOutputStreamClose(out);
        }
    }

    //利用FileInputStream和FileOutputStream进行文件的拷贝
    public static void copyFiles(String oldFile, String newFile) {
        //读取文件
        byte[] buf = IOUtils.printHexByByteArrays(oldFile);
        //写入文件
        IOUtils.writeHexByByteArrays(newFile, buf, 0, buf.length);
    }

    /**
     * 关闭FileInputStream
     *
     * @param in
     */
    public static void FileInputStreamClose(FileInputStream in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭FileOutputStream
     *
     * @param out
     */
    public static void FileOutputStreamClose(FileOutputStream out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * DataInputStream的操作
     *
     * @param fileName
     */
    public static DataInputStream DataInputStreamOpts(String fileName) {
        DataInputStream dis = null;

        try {
            //DataOutputStream需要对FileOutputStream进行包装
            dis = new DataInputStream(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dis;
    }

    /**
     * DataOutputStream的操作
     *
     * @param fileName
     */
    public static DataOutputStream DataOutputStreamOpts(String fileName) {
        DataOutputStream dos = null;

        try {
            //DataOutputStream需要对FileOutputStream进行包装
            dos = new DataOutputStream(new FileOutputStream(fileName, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dos;
    }

    /**
     * DataOutputStream的关闭
     *
     * @param dos
     */
    public static void DataOutputStreamClose(DataOutputStream dos) {
        if (dos != null) {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * DataInputStream的关闭
     *
     * @param dis
     */
    public static void DataInputStreamClose(DataInputStream dis) {
        if (dis != null) {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * BufferedInputStream操作
     *
     * @param fileName
     * @return
     */
    public static BufferedInputStream BufferedInputStreamOpts(String fileName) {
        BufferedInputStream bis = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bis;
    }

    /**
     * BufferedOutputStream操作
     *
     * @param fileName
     * @return
     */
    public static BufferedOutputStream BufferedOutputStreamOpts(String fileName) {
        BufferedOutputStream bos = null;

        try {
            bos = new BufferedOutputStream(new FileOutputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos;
    }

    /**
     * BufferedInputStream的关闭
     *
     * @param bis
     */
    public static void BufferedInputStreamClose(BufferedInputStream bis) {
        if (bis != null) {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * BufferedOutputStream的关闭
     *
     * @param bos
     */
    public static void BufferedOutputStreamClose(BufferedOutputStream bos) {
        if (bos != null) {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * InputStreamReader操作
     *
     * @param fileName
     * @return
     */
    public static InputStreamReader InputStreamReaderOpt(String fileName) {
        InputStreamReader isr = null;

        try {
            //指定读取编码格式
            isr = new InputStreamReader(new FileInputStream(fileName), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isr;
    }

    /**
     * OutputStreamWriter操作
     *
     * @param fileName
     * @return
     */
    public static OutputStreamWriter OutputStreamWriterOpt(String fileName) {
        OutputStreamWriter osr = null;

        try {
            osr = new OutputStreamWriter(new FileOutputStream(fileName), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return osr;
    }

    /**
     * InputStreamReader关闭
     *
     * @param isr
     */
    public static void InputStreamReaderClose(InputStreamReader isr) {
        if (isr != null) {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * OutputStreamWriter关闭
     *
     * @param osr
     */
    public static void OutputStreamWriterClose(OutputStreamWriter osr) {
        if (osr != null) {
            try {
                osr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * FileReader操作
     * @param fileName
     * @return
     */
    public static FileReader FileReaderOpt(String fileName) {
        FileReader fr = null;

        try {
            fr = new FileReader(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fr;
    }

    /**
     * FileWriter操作
     * @param fileName
     * @return
     */
    public static FileWriter FileWriterOpt(String fileName) {
        FileWriter fw = null;

        try {
            //true，不覆盖，进行追加
            fw = new FileWriter(fileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fw;
    }

    /**
     * FileReader关闭
     * @param fr
     */
    public static void FileReaderClose(FileReader fr) {
        if (fr != null) {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * FileReader关闭
     * @param fW
     */
    public static void FileWriterClose(FileWriter fW) {
        if (fW != null) {
            try {
                fW.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
