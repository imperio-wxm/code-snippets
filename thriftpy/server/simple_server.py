#!/usr/bin/env python
# -*- coding: utf-8 -*-

import thriftpy
from thriftpy.rpc import make_server
import os

class MyRPC(object):
    # 提供调用的方法
    def print_fun(self,name):
        str = "Hello " + name
        return str

if __name__ == "__main__":
    file_path = os.path.abspath("../conf/simple.thrift")
    # 加载注册文件
    simple_thrift = thriftpy.load(file_path, module_name="simple_thrift")

    server = make_server(simple_thrift.RPCTest, MyRPC(), '192.168.1.105', 6000)
    print "Thriftpy listening 6000......"
    server.serve()