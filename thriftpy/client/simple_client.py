#!/usr/bin/env python
# -*- coding: utf-8 -*-

import thriftpy
from thriftpy.rpc import make_client
import os

if __name__ == "__main__":
    file_path = os.path.abspath("../conf/simple.thrift")

    # 加载注册文件
    simple_thrift = thriftpy.load(file_path, module_name="simple_thrift")

    client = make_client(simple_thrift.RPCTest, '192.168.1.105', 6000)
    print client.print_fun("wxmimperio")