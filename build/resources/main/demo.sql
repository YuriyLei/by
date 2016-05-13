/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-05-13 15:43:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `attachment_id` varchar(255) DEFAULT NULL,
  `content` longtext,
  `content_type` smallint(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '2016-05-04 14:20:40', null, '0', null, null, null, '交付给', '0', '干嘛', '2');

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `attachment_address` varchar(255) DEFAULT NULL,
  `attachment_name` varchar(255) DEFAULT NULL,
  `news_id` bigint(20) DEFAULT NULL,
  `short_id` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO `attachment` VALUES ('117', '2016-04-26 16:42:10', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test1.2016-04-26.docx', 'test1.docx', null, '14.324486871319941', '0');
INSERT INTO `attachment` VALUES ('118', '2016-04-26 16:42:10', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test2.2016-04-26.docx', 'test2.docx', null, '14.324486871319941', '0');
INSERT INTO `attachment` VALUES ('119', '2016-04-26 16:44:40', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test3.2016-04-26.docx', 'test3.docx', null, '16.89877052671769', '0');
INSERT INTO `attachment` VALUES ('120', '2016-04-26 16:44:40', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test4.2016-04-26.docx', 'test4.docx', null, '16.89877052671769', '0');
INSERT INTO `attachment` VALUES ('121', '2016-04-26 16:46:49', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test5.2016-04-26.docx', 'test5.docx', null, '7.702322253865809', '0');
INSERT INTO `attachment` VALUES ('122', '2016-04-26 16:46:49', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test6.2016-04-26.docx', 'test6.docx', null, '7.702322253865809', '0');
INSERT INTO `attachment` VALUES ('123', '2016-04-26 16:47:46', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test8.2016-04-26.docx', 'test8.docx', null, '7.514736689650967', '0');
INSERT INTO `attachment` VALUES ('124', '2016-04-26 16:47:46', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test7.2016-04-26.docx', 'test7.docx', null, '7.514736689650967', '0');
INSERT INTO `attachment` VALUES ('125', '2016-04-26 16:49:09', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test10.2016-04-26.docx', 'test10.docx', null, '12.368826204586533', '0');
INSERT INTO `attachment` VALUES ('126', '2016-04-26 16:49:09', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test9.2016-04-26.docx', 'test9.docx', null, '12.368826204586533', '0');
INSERT INTO `attachment` VALUES ('127', '2016-04-26 16:51:55', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\women shi .2016-04-26.docx', 'women shi .docx', null, '14.14625942984221', '0');
INSERT INTO `attachment` VALUES ('128', '2016-04-26 16:54:44', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test1.2016-04-26.docx', 'test1.docx', null, '15.643194482591255', '0');
INSERT INTO `attachment` VALUES ('129', '2016-04-26 16:58:27', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test2.2016-04-26.docx', 'test2.docx', null, '12.935759393884524', '0');
INSERT INTO `attachment` VALUES ('130', '2016-04-26 17:00:55', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test5.2016-04-26.docx', 'test5.docx', null, '1.9573300310596657', '0');
INSERT INTO `attachment` VALUES ('131', '2016-04-26 17:00:55', null, '0', null, null, '0', '/upload/attachment/2016-04-26\\test6.2016-04-26.docx', 'test6.docx', null, '1.9573300310596657', '0');
INSERT INTO `attachment` VALUES ('132', '2016-04-26 17:07:03', null, '0', null, null, '1', '/upload/attachment/2016-04-26\\test7.2016-04-26.docx', 'test7.docx', '83', '3392432346620407', '1');
INSERT INTO `attachment` VALUES ('133', '2016-04-26 17:10:37', null, '0', null, null, '1', '/upload/attachment/2016-04-26\\test8.2016-04-26.docx', 'test8.docx', '84', '4918713555546367', '1');
INSERT INTO `attachment` VALUES ('134', '2016-04-26 17:23:00', null, '0', null, null, '1', '/upload/attachment/2016/2016-04\\test8.2016-04-26.docx', 'test8.docx', '85', '0651940680254115', '1');
INSERT INTO `attachment` VALUES ('135', '2016-04-26 17:23:00', null, '0', null, null, '1', '/upload/attachment/2016/2016-04\\test6.2016-04-26.docx', 'test6.docx', '85', '0651940680254115', '1');
INSERT INTO `attachment` VALUES ('136', '2016-04-26 17:23:00', null, '0', null, null, '1', '/upload/attachment/2016/2016-04\\test7.2016-04-26.docx', 'test7.docx', '85', '0651940680254115', '1');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `attachment_id` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `is_carousel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', '2016-05-13 10:11:53', null, '0', null, null, '/img/imageNews/lb1.jpg', null, '123456789789', '1111', '4', '1');
INSERT INTO `image` VALUES ('2', '2016-05-13 10:12:29', null, '0', null, null, '/img/imageNews/lb2.jpg', null, '7896786786', '2222', '4', '1');
INSERT INTO `image` VALUES ('3', '2016-05-13 10:13:13', null, '0', null, null, '/img/imageNews/lb3.gif', null, 'fgjdghsdf', '3333', '4', '1');
INSERT INTO `image` VALUES ('4', '2016-05-13 13:58:09', null, '0', null, null, '/img/imageNews/lb4.jpg', null, 'ggggggggggghhhhhhhhhhhhhhhhhh', 'tutututu', '4', '0');
INSERT INTO `image` VALUES ('5', '2016-05-13 13:58:36', null, '0', null, null, '/img/imageNews/lb4.jpg', null, '444444444444', '44444444', '4', '0');
INSERT INTO `image` VALUES ('6', '2016-05-13 13:59:33', null, '0', null, null, '/img/imageNews/lb4.jpg', null, '5555555', '555555555', '4', '0');
INSERT INTO `image` VALUES ('7', '2016-05-13 13:59:28', null, '0', null, null, '/img/imageNews/lb4.jpg', null, 'uytuytyty', 'ikikiki', '4', '0');
INSERT INTO `image` VALUES ('8', '2016-05-13 13:59:43', null, '0', null, null, '/img/imageNews/lb4.jpg', null, 'gdfghdfs', 'dfgsdfg', '4', '0');
INSERT INTO `image` VALUES ('9', '2016-05-13 14:00:14', null, '0', null, null, '/img/imageNews/lb4.jpg', null, 'fdghdfgh', 'gnfjfg', '4', '0');
INSERT INTO `image` VALUES ('10', '2016-05-13 14:00:24', null, '0', null, null, '/img/imageNews/lb4.jpg', null, 'gfdgdf', 'fghfg', '4', '0');
INSERT INTO `image` VALUES ('11', '2016-05-13 14:00:49', null, '0', null, null, '/img/imageNews/lb4.jpg', null, 'rfghfgh', 'fdghd', '4', '0');

-- ----------------------------
-- Table structure for important
-- ----------------------------
DROP TABLE IF EXISTS `important`;
CREATE TABLE `important` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `attachment_id` varchar(255) DEFAULT NULL,
  `content` longtext,
  `content_type` smallint(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of important
-- ----------------------------
INSERT INTO `important` VALUES ('1', null, null, '0', null, null, '0', null, '交付给', '0', '干嘛', '3');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `attachment_id` varchar(255) DEFAULT NULL,
  `content` longtext,
  `content_type` smallint(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('80', null, '1', '0', null, null, '0', null, 'dsfgsdfg', '0', 'test1', '1');
INSERT INTO `notice` VALUES ('81', null, '1', '0', null, null, '0', null, 'asdfasd', '0', 'test2', '1');
INSERT INTO `notice` VALUES ('82', null, '1', '0', null, null, '0', null, 'sdfsdgsd', '0', 'dfssdf', '1');
INSERT INTO `notice` VALUES ('83', null, '1', '0', null, null, '0', '132', '的风格和地方', '0', '的风格和地方', '1');
INSERT INTO `notice` VALUES ('84', null, '1', '0', null, null, '0', '133', '对方过后', '0', '购房计划', '1');
INSERT INTO `notice` VALUES ('85', '2016-05-04 15:25:08', '1', '0', null, null, '0', '134;135;136', 'ASDFASDFhdfggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg', '0', 'FASDFAS', '1');
INSERT INTO `notice` VALUES ('86', null, '1', '0', null, null, '0', null, 'SDFFGSDG', '0', 'GSDFG', '1');
INSERT INTO `notice` VALUES ('92', null, '1', '0', null, null, '0', null, '阿斯顿发送到', '0', '大三的方式', '1');
INSERT INTO `notice` VALUES ('93', null, '1', '0', null, null, '0', null, '交付给', '0', '干嘛', '1');
INSERT INTO `notice` VALUES ('94', null, '1', '0', null, null, '0', null, '/upload/noticeNews/2016/2016-04\\test1.2016-04-28.docx', '1', 'test1.docx', '1');
INSERT INTO `notice` VALUES ('95', null, '1', '0', null, null, '0', null, '/upload/noticeNews/2016/2016-04\\test12.2016-04-28.doc', '1', 'test12.doc', '1');
INSERT INTO `notice` VALUES ('96', null, '1', '0', null, null, '0', null, 'dfgsdfshsdfhsdfsdfgsdfg', '0', 'sdjfksjkdfj', '1');
INSERT INTO `notice` VALUES ('97', '2016-05-04 09:47:05', '1', '0', null, null, '0', null, 'sdfgsdfgsdfgsdfghsdfgh', '0', 'woshiyizhikdjfkjskdj', '1');
INSERT INTO `notice` VALUES ('98', '2016-05-04 09:48:41', '1', '0', null, null, '0', null, 'sdfsdfsadghgkgjljk;lkj', '0', 'gdfsgdf', '1');
INSERT INTO `notice` VALUES ('99', '2016-05-04 09:49:26', '1', '0', null, null, '0', null, 'fghjkfghk', '0', 'yuuyuyuyuyuyuyu', '1');
INSERT INTO `notice` VALUES ('100', '2016-05-04 15:59:21', '1', '0', null, null, '0', null, '<p style=\"text-indent:2em;color:#444444;font-size:14px;\">\n	不懂<a href=\"http://www.sanwen8.cn/z/hehua/\" target=\"_blank\">荷花</a>，却偏偏<a href=\"http://www.sanwen8.cn/sanwen/love/\" target=\"_blank\">爱</a>上她的风雅与独特，以至于常常<a href=\"http://www.sanwen8.cn/z/houhui/\" target=\"_blank\">悔恨</a><a href=\"http://www.sanwen8.cn/z/xiangxinziji/\" target=\"_blank\">自己</a>是个没有内涵的<a href=\"http://www.sanwen8.cn/z/nvren/\" target=\"_blank\">女子</a>，没有诗意，亦没有情怀用仟仟<a href=\"http://www.sanwen.net/\" target=\"_blank\">文字</a>去完整地描绘她的美。记得小<a href=\"http://www.sanwen8.cn/z/shijian/\" target=\"_blank\">时候</a>，附近的邻居们都爱种大片的莲，屋前屋后望<a href=\"http://www.sanwen8.cn/z/cengjing/\" target=\"_blank\">过去</a>都是绿油油的一大片，<a href=\"http://www.sanwen8.cn/sanwen/xiejing/\" target=\"_blank\">景色</a>很是迷人，只是那时候最期待的是莲花可以早点开，早点败，然后会有莲蓬，再就有美味的莲子咯，或许这就是儿时<a href=\"http://www.sanwen8.cn/z/danchun/\" target=\"_blank\">单纯</a>的心思吧，一心想要品尝味道，不懂浪漫，也没有所谓的诗意，仿佛没有脱俗一般，只是寄情在吃上面，想来真是误了西风误了景哟。\n</p>\n<p style=\"text-indent:2em;color:#444444;font-size:14px;\">\n	与荷花的初相遇还是在书中，深知《爱莲说》中对荷花的描写很精妙，读书人不知道的恐怕是绝无仅有的吧，他那有名的一句“香远益清”也是脍炙人口的，特别是后来经常不<a href=\"http://www.sanwen8.cn/z/yuanwang/\" target=\"_blank\">愿意</a>别人触碰自己心爱的东西时，所常道的“可远观而不可亵玩焉”，更是对莲有了不一般的认识，这样说来，一是很好的保护了自己的物品；二是听起来也没有那么言辞犀利，反而很委婉，这样不会得罪听的人的<a href=\"http://www.sanwen8.cn/z/xinqingbuhao/\" target=\"_blank\">心情</a>嘛，是很实用的一句话，更是风靡了好一阵子呢。\n</p>\n<p style=\"text-indent:2em;color:#444444;font-size:14px;\">\n	而真正喜欢上荷花的是在朱自清先生的《荷塘月色》那篇课文中，一段往事一段情，一处风景一处迷，一切景语皆情语嘛！笔下可生花，没有少一字也没有多一语，就那样自然而恰好的将荷花所有的韵致都刻画出来了，读来生动又形象，是我少有喜欢的<a href=\"http://www.sanwen.net/\" target=\"_blank\">文章</a>中的最喜欢，读了那篇课文，想想他的文章能够家喻户晓，也不足为奇了，着实把<a href=\"http://www.sanwen8.cn/z/ye/\" target=\"_blank\">夜</a>晚的荷塘描写得又细致又有情调，仿佛那方荷塘是灵动着，有<a href=\"http://www.sanwen8.cn/z/shengming/\" target=\"_blank\">生命</a>的。\n</p>\n<p style=\"text-indent:2em;color:#444444;font-size:14px;\">\n	就像不知道麦子在什么季节播种和收割一样，我亦不知道荷花具体开在哪一月，只知道大概是在<a href=\"http://www.sanwen8.cn/z/xiatian/\" target=\"_blank\">夏</a>天。所以与荷花亲密接触也不过是前几年的事情，因为一直歆羡着，所以要求<a href=\"http://www.sanwen8.cn/z/jiating/\" target=\"_blank\">家里</a>种了一池，就在不远的地方，远远地眺望，就可以看得很清晰了， 那一年的确大饱眼福，目睹了荷花从“小荷才露尖尖角，早有蜻蜓立上头。”到“秋阴不散霜飞晚，留得残荷听<a href=\"http://www.sanwen8.cn/z/xiayu/\" target=\"_blank\">雨</a>声。” 最终“花自飘零水自流。”的整个过程。<a href=\"http://www.duan8.com/\" target=\"_blank\">短</a>短三个月，足以将一生的美丽绽放了。幼时积攒的有关荷花的诗句，也在那个七月不约而同地涌动出来了，例如“毕竟西湖六月中，风光不与四时同。接天莲叶无穷碧，映日荷花别样红。”大多诗句都是由<a href=\"http://www.sanwen8.cn/z/jiangnan/\" target=\"_blank\">江南</a>美景滋生，因了诗句之美，从此爱上西湖，向往着能去杭州西湖亲眼瞅瞅。\n</p>\n<p style=\"text-indent:2em;color:#444444;font-size:14px;\">\n	很多个日落时分，我都喜欢静坐在塘边石头上，静静地欣赏着荷叶，闻着荷花恬恬的香。“蝉噪林逾静，<a href=\"http://www.sanwen8.cn/z/niao/\" target=\"_blank\">鸟</a>鸣山更幽。”四周的确是寂静得很。我静静地坐在那里，细数着塘中有多少荷花正在开放，那藏在深处的荷花总是若隐若现的，数了几遍也没有理清楚，不耐烦地就放弃了，凝望荷塘，不自觉地就想起了，季羡林先生<a href=\"http://www.sanwen8.cn/z/cengjing/\" target=\"_blank\">曾经</a>描写他“季园”小塘荷花的那些话，那些动人的<a href=\"http://www.ishuo.cn/\" target=\"_blank\">语句</a>是这样说的“水面上看到的荷花是绿肥、红肥。倒影映入水中，风乍起，一片莲瓣堕入水中，它从上面向下落，水中的倒影却是从下边往上落，最后一接触到水面，二者合二为一，像小船似的飘在那里。”我不禁感叹，季先生既是如此喜爱荷花，那小小花瓣飘落的一举一动都深深地刻在了脑海。我不由得心生佩服，大师果然是大师啊，那眼神多犀利，不会放过任何一个可以捕捉的机会呀。\n</p>\n<p style=\"text-indent:2em;color:#444444;font-size:14px;\">\n	思绪跟着微微吹拂的风飘得越来越远，不由感叹，<a href=\"http://www.sanwen8.cn/z/rensheng/\" target=\"_blank\">人生</a>也是如荷花般吧，不论是湛蓝的天空，还是戏水的鱼儿，亦或是在空中盘旋的鸟儿，都不可能<a href=\"http://www.sanwen8.cn/z/yongheng/\" target=\"_blank\">永远</a>停留，不会一直陪在荷花的身边，能无怨<a href=\"http://www.sanwen8.cn/z/houhui/\" target=\"_blank\">无悔</a>地将自己的 身体扎根在淤泥之中，不离不弃地与荷花一起沐浴<a href=\"http://www.sanwen8.cn/z/yangguang/\" target=\"_blank\">阳光</a>，经历<a href=\"http://www.sanwen8.cn/z/xiayu/\" target=\"_blank\">风雨</a>，在短暂的季节里慢慢长大，直到变老的，恐怕只有那片片莲叶咯。人说：“不爱未必无情，爱过也未必珍惜。” 大概也是有道理的吧！\n</p>\n<p style=\"text-indent:2em;color:#444444;font-size:14px;\">\n	荷花能够在短短数月绽放自己的美丽，完成使命，实现价值。而人终其一生，费心费力，年少时候的<a href=\"http://www.sanwen8.cn/z/meng/\" target=\"_blank\">梦</a>想都难以完成，更不要说实现自己的理想咯。很多人，走过大半人生，还在感叹，自己<a href=\"http://www.sanwen8.cn/z/qingchun/\" target=\"_blank\">年轻</a>时候没有抓住机会干自己想要或者喜欢干的事情，老了，即使有那份心情，也再也不会有拼搏的激情了。所以，羡慕荷花静心养性，方能清香远播！\n</p>\n<p style=\"text-indent:2em;color:#444444;font-size:14px;\">\n	愿风裁尘，<a href=\"http://www.sanwen8.cn/z/suiyue/\" target=\"_blank\">岁月</a>不负！经过<a href=\"http://www.sanwen8.cn/z/shijian/\" target=\"_blank\">时间</a>的沉淀和年华的考验，我能够做到“腹有诗书气自华”！\n</p>', '0', '时光优雅，暖了盛夏', '1');
INSERT INTO `notice` VALUES ('101', '2016-05-04 16:10:19', '1', '0', null, null, '0', null, '/upload/noticeNews/2016/2016-05\\槐花飘香.2016-05-04.doc', '1', '槐花飘香', '1');
INSERT INTO `notice` VALUES ('104', '2016-05-04 16:26:39', '1', '0', null, null, '0', null, '<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	烟水脉脉，隔岸桃花盛开的地方，希望君一直都会有最初的笑容。此生，我愿做个情怀温婉的<a href=\"http://baidu.com/\">女子</a>，为君留一头长发，着一袭淡紫长裙，轻挽一季素白年华，静静地在<a href=\"http://www.sanwen8.cn/z/huiyi/\" target=\"_blank\">回忆</a>里<a href=\"http://www.sanwen8.cn/z/dengni/\" target=\"_blank\"><span>等待</span></a>…\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	——题记\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	听一首离歌，挽不住雁鸣声远。容颜就这样在无言的寂静中逝去，没有了你，这座城于我便是空城。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	一声“来世”，空了谁的等待？一句“来世”，空了谁的青瓷？就在“执子之手，与子偕老”这八个闪亮大字如流星般滑落于<a href=\"http://www.sanwen8.cn/z/jimo/\" target=\"_blank\">寂寞</a>沙洲时，我终于明白，从此，<a href=\"http://www.sanwen8.cn/z/xiayu/\" target=\"_blank\">雨</a>楼西檐屋角的风铃再也听不见你乘风而来的脚步声，<a href=\"http://www.sanwen8.cn/z/xiayu/\" target=\"_blank\"><span>烟雨</span></a><a href=\"http://www.sanwen8.cn/z/jiangnan/\" target=\"_blank\"><span>江南</span></a>的某个角落又多了一个与寂寞相依相<a href=\"http://www.sanwen8.cn/sanwen/love/\" target=\"_blank\">爱</a>的女子。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	遥望昨日楼台，已是水月镜花。桨声灯影，水荡烟波，宿命注定你我只是飘渺红尘里同亭避雨的过客，今生，你无法扭转<a href=\"http://www.sanwen8.cn/z/suiyue/\" target=\"_blank\">岁月</a>的年轮，而我也无法登上你漂流的客舟。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	你我走过的小径已落叶满地，坐过的石椅，已青苔遍布，你我共同刻画在梧桐树上的旧影也早已斑驳，只剩一个残缺的心形轮廓。今日，有谁看见一个<a href=\"http://www.sanwen8.cn/z/jimo/\" target=\"_blank\">孤寂</a>身影手握一枝沾满了前尘的笔，在冷风的旋律中，兀自书写着一抹凄迷残红？\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	<a href=\"http://www.sanwen8.cn/z/cengjing/\" target=\"_blank\">曾经</a>，你在左，爱在右，我在<a href=\"http://www.sanwen8.cn/z/xingfu/\" target=\"_blank\">幸福</a>中聆听风中笛，凝望彼岸花。当萧瑟的秋风吹落泛黄的树叶，划出季节变更的弧线，我独自走过一条又一条街道，看万盏灯火渐次熄灭，待到尘埃落定，四周一片黑暗，幸福已悄然与我诀别。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	江南的<a href=\"http://www.sanwen8.cn/z/ye/\" target=\"_blank\">夜</a>雨，涨了谁的秋池？江南的烟火，映亮了谁的寂寞？雁来雁回中，我只能依着旧时的亭台，拈一朵相思的花，借一缕回忆的风，弹奏一首婉约缠绵的<a href=\"http://www.sanwen8.cn/sanwen/love/\" target=\"_blank\">爱情</a>绝唱，听雨声响彻在<a href=\"http://www.sanwen8.cn/z/meng/\" target=\"_blank\">梦</a>里<a href=\"http://www.sanwen8.cn/z/ye/\" target=\"_blank\"><span>夜<span>空</span></span></a>……\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	寂寞，是谁给的苦？浮生若梦，为欢几何？“自在飞花轻似梦，无边丝雨细如愁。”是谁将一幕幕<a href=\"http://www.sanwen8.cn/z/huiyi/\" target=\"_blank\">记忆</a>，折叠成泛黄的纸张？是谁将<a href=\"http://www.sanwen8.cn/z/jimo/\" target=\"_blank\">寂寥</a>的念想，绽放成葱茏的模样？那玫瑰的花香，会<a href=\"http://www.sanwen8.cn/z/yongheng/\" target=\"_blank\">永久</a>的在我掌心散开，不会消散，你留下的书卷味道，注定薰醉我一生一世。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	君，纵然你<a href=\"http://www.sanwen8.cn/z/likai/\" target=\"_blank\">离去</a>，你的剪影依然在我眸中曳动，依然在我梦里穿行……无你的岁月，我总是迷乱在你的一字一句之间，在流年的光影里，你如一首隔世的曲子始终袅绕在我的记忆里，那么清晰，那么动听。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	闭上眼，任回忆把昨天的剧情一演再演。我用一阕无韵无律的词，于散落的芬芳花间，拾起一段段往事，然后躲在独我的世界里，默默感受那一缕划过心海的<a href=\"http://www.sanwen8.cn/z/xintong/\" target=\"_blank\">疼痛</a>。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	无数次想你的<a href=\"http://www.sanwen8.cn/z/shijian/\" target=\"_blank\">时候</a>，我<a href=\"http://www.sanwen8.cn/z/xintong/\" target=\"_blank\">心痛</a>得无法呼吸，但，每次要泪落的时候，我都会告诉<a href=\"http://www.sanwen8.cn/z/xiangxinziji/\" target=\"_blank\">自己</a>要<a href=\"http://www.sanwen8.cn/z/jianqiang/\" target=\"_blank\">坚强</a>，尽管已盼不到如故，回不了当初，可我还是告诉自己要选择不哭，因为爱你，更是因为懂你，所以，我继续微笑着在回忆里<a href=\"http://www.sanwen8.cn/z/dengni/\" target=\"_blank\"><span>等你</span></a>……一江<a href=\"http://www.sanwen8.cn/z/chuntian/\" target=\"_blank\">春</a>水梦里只为你搁浅，今生哪怕把青丝熬成白发，把红颜耗成落花，我也无怨<a href=\"http://www.sanwen8.cn/z/houhui/\" target=\"_blank\">无悔</a>！\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	总是喜欢在<a href=\"http://www.sanwen8.cn/z/xiayu/\" target=\"_blank\">雨天</a>，透过朦胧的湖面看雨滴不断打碎自己的倒影；总是喜欢在夜里，燃几个小小的烟花，让寂寞的心感受片刻的<a href=\"http://www.sanwen8.cn/z/wennuan/\" target=\"_blank\">温暖</a>；总是喜欢隐藏在桃花或柳荫深处，吹一曲你钟爱的曲，刻意，不问来路，不问归处，曲终不问人聚散。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	今后，无论你来或不来，我都会以花的姿态在烟雨江南静静地等候，不管纷飞的<a href=\"http://www.sanwen8.cn/z/xiayu/\" target=\"_blank\">细雨</a>打湿多少干涸的记忆，不管来往的冷风拉长多少萧索的疼痛，若风瑟夜冷凝固了一屋的红烛<a href=\"http://www.sanwen8.cn/z/yanlei/\" target=\"_blank\">泪痕</a>，我依然会端坐在<a href=\"http://www.sanwen8.cn/z/shijian/\" target=\"_blank\">时光</a>的转角处，用力撑起一方无雨的空间，腾挪一地的沧桑，挽一眉浅笑，盼一场再相遇。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	你说，最爱看我用<a href=\"http://www.sanwen8.cn/z/yueliang/\" target=\"_blank\">月光</a>作饰物，最想感受我那一头长发飘起的温柔，所以，今生，我愿散发待君束，长发为君留，在月光中为你守候，为你等待。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	我爱你温良如玉的模样，爱你清逸出尘的身影，爱你温文尔雅的气质，爱你所有的所有。“只缘感君一回顾，使我常思朝与暮”，很想让君知道，其实，这一生回忆有你就足够！若有来生，惟愿心不再飘零，许我一世倾城之恋。\n</p>\n<p style=\"margin-left:0cm;text-indent:24.0pt;background:white;\">\n	眼前，那风中摇曳飞舞的落叶，是不是你随风寄来的相思？君，如果我看你看过的风景，走你走过的路，握紧了落叶，再乘上记忆的筏，是不是，就能更靠近你一点？\n</p>\n<p class=\"MsoNormal\">\n	<span>&nbsp;</span>\n</p>', '0', '只缘感君一回顾，使我常思朝与暮', '1');
INSERT INTO `notice` VALUES ('105', '2016-05-09 11:20:34', null, '0', null, null, '0', null, '/upload/noticeNews/2016/2016-05\\lss.2016-05-09.jpg', '1', 'lss', '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', null, null, null, null, null, null, 'user:edit', '1', '用户编辑');
INSERT INTO `permission` VALUES ('2', null, null, null, null, null, null, 'user:look', '2', '查看用户');
INSERT INTO `permission` VALUES ('3', null, null, null, null, null, null, 'user:addUser', '1', '添加用户');
INSERT INTO `permission` VALUES ('4', null, null, null, null, null, null, 'user:updateUser', '1', '更新用户');
INSERT INTO `permission` VALUES ('5', null, null, null, null, null, null, 'notice:addNotice', '1', '添加通知公告');
INSERT INTO `permission` VALUES ('6', null, null, null, null, null, null, 'notice:uploadNotice', '1', '上传通知公告');
INSERT INTO `permission` VALUES ('7', null, null, null, null, null, null, 'notice:addNoticeWithAttachment', '1', '添加带附件的通知公告');
INSERT INTO `permission` VALUES ('8', null, null, null, null, null, null, 'activity:addActivity', '1', '添加学生活动');
INSERT INTO `permission` VALUES ('9', null, null, null, null, null, null, 'activity:uploadActivity', '1', '上传学生活动');
INSERT INTO `permission` VALUES ('10', null, null, null, null, null, null, 'activity:addActivityWithAttachment', '1', '添加带附件的学生活动');
INSERT INTO `permission` VALUES ('11', null, null, null, null, null, null, 'user:look', '1', '查看用户');
INSERT INTO `permission` VALUES ('12', null, null, null, null, null, null, 'important:addImportant', '1', '添加学院新闻');
INSERT INTO `permission` VALUES ('13', null, null, null, null, null, null, 'important:uploadImportant', '1', '上传学院新闻');
INSERT INTO `permission` VALUES ('14', null, null, null, null, null, null, 'important:addImportantWithAttachment', '1', '添加带附件的学院新闻');
INSERT INTO `permission` VALUES ('15', null, null, null, null, null, null, 'role:look', '1', '查看角色');
INSERT INTO `permission` VALUES ('16', null, null, null, null, null, null, 'role:addRole', '1', '添加角色');
INSERT INTO `permission` VALUES ('17', null, null, null, null, null, null, 'important:addImportant', '3', '添加学院新闻');
INSERT INTO `permission` VALUES ('18', null, null, null, null, null, null, 'important:uploadImportant', '3', '上传学院新闻');
INSERT INTO `permission` VALUES ('19', null, null, null, null, null, null, 'important:addImportantWithAttachment', '3', '添加带附件的学院新闻');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `position_name` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '2016-05-05 17:26:42', '1', '0', '2016-05-05 17:26:52', '1', '超级管理员');
INSERT INTO `role` VALUES ('2', '2016-05-09 09:32:19', '1', '0', '2016-05-09 09:32:28', '1', '管理员');
INSERT INTO `role` VALUES ('3', '2016-05-12 15:37:46', '1', '0', '2016-05-12 15:37:54', '1', '学院新闻管理员');
INSERT INTO `role` VALUES ('4', '2016-05-12 15:38:34', '1', '0', '2016-05-12 15:38:27', '1', '通知公告管理员');
INSERT INTO `role` VALUES ('5', '2016-05-12 15:39:00', '1', '0', '2016-05-12 15:38:55', '1', '学生活动管理员');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `portrait` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_code` bigint(20) DEFAULT NULL,
  `year` smallint(6) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2016-05-04 14:37:04', '0', '0', '2016-05-04 14:39:09', null, '博士', '你好', '教授', '58b39697e0f9f297f8c15952da3c618b', null, '余磊', '软件', '130160035', '1994', '教务处', '1');
INSERT INTO `user` VALUES ('2', '2016-05-09 09:30:43', '1', '0', '2016-05-09 09:30:48', null, '本科', '你哈哈', '讲师', 'e10adc3949ba59abbe56e057f20f883e', null, 'yulei', '计算机', '130160085', '1994', '财务处', '2');
INSERT INTO `user` VALUES ('3', '2016-05-11 14:32:36', '1', '0', '2016-05-12 15:39:17', null, '博士后', '范德萨发生', '院长', '6277a392a56d06ddf852daf2a0f36abb', null, '于磊磊', 'c++', '130160045', '1990', '教务处', '0');
INSERT INTO `user` VALUES ('5', '2016-05-12 10:54:05', '1', '0', '2016-05-12 15:28:08', '1', '专科', '你好', '讲师', null, null, '鱼鱼泪', '软件工程', '130160100', '1994', '财务处', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `deleted` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', null, null, null, null, null, '1', '1');
INSERT INTO `user_role` VALUES ('2', null, null, null, null, null, '2', '2');
INSERT INTO `user_role` VALUES ('3', null, null, null, null, null, '3', '3');
INSERT INTO `user_role` VALUES ('4', null, null, null, null, null, '3', '3');
