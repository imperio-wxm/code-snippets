#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = 'wxmimperio'

import thriftpy
from thriftpy.rpc import make_server
import os

class MyFileRPC(object):
    def file_server(self, file_list):
        if file_list:
            files_path = os.path.abspath("../")
            for item in file_list:
                with open(files_path + "/" + item[0], "wb") as file:
                    file.write(item[1].decode("base64"))
            return "file create!"
        else:
            return "file_list is empty!"

def server_start(conf_path, server_ip, server_port):
    # 加载注册文件
    file_thrift = thriftpy.load(conf_path, module_name="file_thrift")
    server = make_server(file_thrift.FileRPC, MyFileRPC(), server_ip, server_port)
    print "Thriftpy listening " + str(server_port) + "......"
    server.serve()

if __name__ == "__main__":
    conf_path = os.path.abspath("../conf/file.thrift")
    server_start(conf_path, "192.168.1.105", 6000)