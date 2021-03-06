/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hbase.util;

import java.io.IOException;

import org.apache.yetus.audience.InterfaceAudience;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

/**
 * <a href="http://www.mapr.com/">MapR</a> implementation.
 */
@InterfaceAudience.Private
public class FSMapRUtils extends FSUtils {
  private static final Logger LOG = LoggerFactory.getLogger(FSMapRUtils.class);

  @Override
  public void recoverFileLease(final FileSystem fs, final Path p,
      Configuration conf, CancelableProgressable reporter) throws IOException {
    LOG.info("Recovering file " + p.toString() +
      " by changing permission to readonly");
    FsPermission roPerm = new FsPermission((short) 0444);
    fs.setPermission(p, roPerm);
  }
}
