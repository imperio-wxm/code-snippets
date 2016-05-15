#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = 'wxmimperio'

import thriftpy
from thriftpy.rpc import make_client
import os

def client_start(conf_path, client_ip, client_port):
    file_thrift = thriftpy.load(conf_path, module_name="file_thrift")
    return make_client(file_thrift.FileRPC, client_ip, client_port)

def opt_files(files_path_list):
    files_context_list = []
    files_name_list = []

    for item in files_path_list:
        with open(item, "rb") as files:
            files_context_list.append(files.read().encode("base64"))
        # 获取文件名
        files_name_list.append(item.split('/')[-1])
    return zip(files_name_list, files_context_list)

if __name__ == "__main__":
    conf_path = os.path.abspath("../conf/file.thrift")
    client = client_start(conf_path, "192.168.1.105", 6000)

    files_path_list = []
    files_path_list.append(os.path.abspath("../files/markdown.md"))
    files_path_list.append(os.path.abspath("../files/markdown.pdf"))
    files_path_list.append(os.path.abspath("../files/photo.jpg"))

    files_info = opt_files(files_path_list)
    print client.file_server(files_info)