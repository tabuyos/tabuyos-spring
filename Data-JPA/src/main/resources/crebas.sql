/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/4/16 11:01:14                           */
/*==============================================================*/

drop database if exists vers;

/*==============================================================*/
/* Database: vers                                               */
/*==============================================================*/
create database vers character set utf8mb4;

use vers;

/*==============================================================*/
/* Table: ask_answer                                            */
/*==============================================================*/
create table ask_answer
(
   id                   bigint not null auto_increment comment '主键id',
   ask_user_id          bigint comment '用户id',
   ask_user_name        varchar(100) comment '提问人',
   ask_title            varchar(255) comment '提问标题',
   ask_content          text comment '提问内容',
   ask_pay_num          integer comment '提问支付金额',
   answer_user_id       bigint comment '回答人id',
   answer_user_name     varchar(100) comment '回答人',
   answer_content       text comment '回答内容',
   answer_state         boolean default false comment '回答状态',
   open_state           boolean default false comment '公开状态',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: collection                                            */
/*==============================================================*/
create table collection
(
   id                   bigint not null auto_increment comment '主键id',
   user_id              bigint comment '用户id',
   subject_id           varchar(50) not null comment '试题id ',
   subject_stem         varchar(255) comment '试题题干',
   paper_id             varchar(50) comment '试卷id',
   paper_stem           varchar(255) comment '试卷标题',
   collection_type      integer comment '收藏类型(0:试题;1:试卷)',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: discuss                                               */
/*==============================================================*/
create table discuss
(
   id                   bigint not null comment '主键id',
   user_id              bigint not null comment '用户id',
   parent_id            bigint comment '父级id',
   subject_id           varchar(50) comment '试题id',
   explain_id           bigint comment '讲解id',
   ask_answer_id        bigint comment '问答id',
   discuss_content      text comment '评论回复内容',
   thumbs_up            integer default 0 comment '获赞',
   discuss_type         integer default 0 comment '类型(0:试题;1:问答;2:讲解)',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: exam_news                                             */
/*==============================================================*/
create table exam_news
(
   id                   bigint not null,
   exam_category_id     bigint not null comment '考试类别id',
   exam_category        varchar(200) comment '考试类别',
   news_title           varchar(255) not null comment '新闻标题',
   news_content         text comment '新闻内容',
   img_url              varchar(255) comment '新闻封面',
   news_author          varchar(100) comment '新闻作者',
   news_source          varchar(100) comment '新闻来源',
   release_time         datetime comment '发布时间',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: exam_question_explain                                 */
/*==============================================================*/
create table exam_question_explain
(
   id                   bigint not null auto_increment comment '主键id',
   user_id              bigint comment '用户id',
   user_name            varchar(100) comment '用户名',
   subject_id           varchar(50) not null comment '试题id',
   subject_stem         varchar(255) comment '试题题干',
   explain_title        varchar(50) comment '讲解标题',
   expalin_describe     text comment '讲解描述',
   explain_file_type    integer comment '文件类型',
   explain_file_size    bigint comment '文件大小',
   see_free_num         integer comment '免费查看人数',
   pay_num              integer comment '付费金额',
   examine_state        integer default 0 comment '审核状态(-1:未通过;0待审核;1:已通过)',
   thumbs_up            integer default 0 comment '点赞',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: exam_questions_download                               */
/*==============================================================*/
create table exam_questions_download
(
   id                   bigint not null auto_increment comment '主键id',
   user_id              bigint comment '用户id',
   paper_id             varchar(50) not null comment '试卷id',
   paper_title          varchar(255) comment '试卷的名',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: exam_questions_note                                   */
/*==============================================================*/
create table exam_questions_note
(
   id                   bigint not null auto_increment comment '主键id',
   user_id              bigint comment '用户id',
   subject_id           varchar(50) comment '试题id',
   subject_stem         varchar(255) comment '试题题干',
   content              text comment '笔记内容',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: exam_wrong_questions                                  */
/*==============================================================*/
create table exam_wrong_questions
(
   id                   bigint not null auto_increment comment '主键id',
   user_id              bigint comment '用户id',
   subject_id           varchar(50) comment '试题id',
   subject_stem         varchar(255) comment '题干',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: gather_watch                                          */
/*==============================================================*/
create table gather_watch
(
   id                   bigint not null auto_increment comment '主键id',
   user_id              bigint comment '用户id',
   ask_answer_id        bigint comment '问答id',
   ask_answer_name      varchar(255) comment '问题题干',
   watch_pay_num        integer comment '支付金额',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: organ                                                 */
/*==============================================================*/
create table organ
(
   id                   bigint not null comment '主键',
   ip_range_start       varchar(100) comment '所属IP段开始',
   ip_range_end         varchar(100) comment '所属IP段结束',
   package_start_time   datetime comment '包库开始时间',
   package_end_time     datetime comment '包库结束时间',
   name                 varchar(100) comment '机构名',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: paper_tbl                                             */
/*==============================================================*/
create table paper_tbl
(
   epid                 varchar(50) comment '试卷编号',
   ecid                 integer comment '试卷分类编号',
   cid                  integer comment '课程编号',
   view_name            varchar(255) comment '试卷名称',
   remark               varchar(255) comment '试卷描述',
   desc_info            varchar(255) comment '试卷备注（要显示到前台）',
   total_score          numeric(5,2) comment '试卷分数',
   subjecy_num          integer comment '试题数量',
   exam_time            integer comment '试卷考试时长',
   exam_type            integer comment '试卷类型',
   exam_state           integer comment '试卷状态',
   region               varchar(5) comment '所属地区',
   book_name            varchar(100) comment '书名',
   chapter              varchar(50) comment '章',
   section              varchar(50) comment '节',
   search_key           varchar(255) comment '试题关键词',
   orgin_code           varchar(50) comment '所属机构',
   border               integer comment '可见范围',
   create_user          varchar(50) comment '创建人',
   modify_user          varchar(50) comment '修改人',
   source_time          datetime comment '试卷源时间',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   is_sequential        integer comment '序号是否连续',
   integnity_state      integer comment '完整度',
   publish_state        varchar(100) comment '出版机构',
   author               varchar(100) comment '作者'
)charset = utf8mb4;

/*==============================================================*/
/* Table: subject_tbl                                           */
/*==============================================================*/
create table subject_tbl
(
   sid                  varchar(50) not null comment '试题id',
   subject_state        integer comment '试题可见(0不可见)',
   subject_name         varchar(255) comment '试题名称',
   subject_type         integer comment '试卷类型',
   ecid                 integer comment '分类编号',
   cid                  integer comment '课程编号',
   bookname             varchar(200) comment '来源书名',
   chapter              varchar(50) comment '章',
   section              varchar(50) comment '节',
   child_num            integer comment '小题数量',
   score                numeric(10,2) comment '试题分值',
   score_line           varchar(255) comment '分值分布',
   show_style           integer comment '显示样式（1单选题，2多选题，3判断题，4填空题，5问答题）',
   stid                 varchar(50) comment '所属标准题型',
   search_key           varchar(255) comment '试题关键字',
   difficulty           integer comment '试题难易度',
   eid                  varchar(50) comment '来源试卷编号',
   region               varchar(5) comment '所属地区',
   create_user          varchar(50) comment '创建人',
   modify_user          varchar(50) comment '修改人',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   content              text comment '详细内容',
   rank_style           varchar(255) comment '子题序号样式',
   search_mark          integer default 0 comment '查询标识（0-正常）',
   primary key (sid)
)charset = utf8mb4;

/*==============================================================*/
/* Table: transaction_details                                   */
/*==============================================================*/
create table transaction_details
(
   id                   bigint not null comment '主键id',
   user_id              bigint comment '用户id',
   user_name            varchar(100) comment '用户名',
   trader_id            bigint not null comment '交易人id',
   trader               varchar(100) comment '交易人',
   trader_method        varchar(30) comment '支付方式',
   trader_serial_num    bigint not null comment '支付流水号',
   trader_source        integer comment '收入来源（0:回答收益;1:围观分成;2:讲解收入）',
   trader_num           integer comment '收入金额',
   flag                 bit comment '交易标识（0:付款;1:收款）',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: user_error_correction                                 */
/*==============================================================*/
create table user_error_correction
(
   id                   bigint not null auto_increment comment '主键id',
   user_id              bigint comment '用户id',
   subject_id           varchar(50) comment '试题id',
   wrong_type           integer default 0 comment '错误类型(0:答案有问题;1:答案与解析不相符;2:有错别字;3:选项有问题;4:其他)',
   wrong_content        text comment '错误内容',
   adopt                bit comment '是否采纳(0:否;1:是)',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: user_rush_record                                      */
/*==============================================================*/
create table user_rush_record
(
   id                   bigint not null comment '主键id',
   user_id              bigint not null comment '用户id',
   do_question_num      integer comment '做题数量',
   wrong_num            integer comment '错误数量统计',
   correct_num          integer comment '正确数量统计',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

/*==============================================================*/
/* Table: vers_user                                             */
/*==============================================================*/
create table vers_user
(
   id                   bigint not null comment '主键id',
   name                 varchar(100) comment '用户名',
   nickname             varchar(100) comment '昵称',
   cover                varchar(200) comment '头像',
   phone                integer(18) comment '手机号',
   exam_date            datetime comment '考试时间',
   exam_category_id     bigint comment '考试类别id',
   exam_category        bigint comment '考试类别',
   organ                varchar(50) comment '所属机构',
   organ_id             bigint comment '所属机构id',
   graduated            varchar(50) comment '毕业院校',
   openId               bigint comment 'openId',
   download_free_num    integer comment '免费下载次数',
   delete_state         boolean default false comment '删除状态',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
)charset = utf8mb4;

alter table ask_answer add constraint FK_Reference_15 foreign key (ask_user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table collection add constraint FK_Reference_6 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table discuss add constraint FK_Reference_17 foreign key (ask_answer_id)
      references ask_answer (id) on delete restrict on update restrict;

alter table discuss add constraint FK_Reference_19 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table discuss add constraint FK_Reference_20 foreign key (explain_id)
      references exam_question_explain (id) on delete restrict on update restrict;

alter table exam_question_explain add constraint FK_Reference_1 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table exam_questions_download add constraint FK_Reference_7 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table exam_questions_note add constraint FK_Reference_5 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table exam_wrong_questions add constraint FK_Reference_2 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table gather_watch add constraint FK_Reference_12 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table gather_watch add constraint FK_Reference_16 foreign key (ask_answer_id)
      references ask_answer (id) on delete restrict on update restrict;

alter table transaction_details add constraint FK_Reference_13 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table user_error_correction add constraint FK_Reference_4 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table user_rush_record add constraint FK_Reference_18 foreign key (user_id)
      references vers_user (id) on delete restrict on update restrict;

alter table vers_user add constraint FK_Reference_10 foreign key (organ_id)
      references organ (id) on delete restrict on update restrict;

