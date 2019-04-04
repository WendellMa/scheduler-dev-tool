

CREATE TABLE `timer_task_group` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
`group_id` bigint(64) UNSIGNED NOT NULL DEFAULT 0 COMMENT '分组Id',
`group_name` varchar(32) NOT NULL DEFAULT '' COMMENT '分组名称',
`group_desc` varchar(255) NULL COMMENT '分组描述',
`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
`deleted_at` timestamp NOT NULL DEFAULT 0 COMMENT '删除时间',
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_group_id` (`group_id` ASC) USING BTREE,
UNIQUE INDEX `uk_group_name` (`group_name` ASC, `is_deleted` ASC, `deleted_at` ASC) USING BTREE
)
COMMENT = '定时器分组表';
CREATE TABLE `timer_task_template` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
`if_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
`deleted_at` timestamp NOT NULL DEFAULT 0 COMMENT '删除时间',
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`template_id` bigint(11) UNSIGNED NOT NULL COMMENT '模板名称',
`template_name` varchar(32) NOT NULL,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_template_id`(`template_id`,`if_deleted`,`deleted_at` ASC)
)
COMMENT = '模板';
CREATE TABLE `timer_task_info` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
`task_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '任务Id',
`trace_id` varchar(32) NULL COMMENT '定时器服务的taskId',
`group_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '分组Id',
`task_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
`task_alias` varchar(64) NOT NULL DEFAULT '' COMMENT '任务别名',
`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
`deleted_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '删除时间',
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_task_id` (`task_id` ASC) USING BTREE,
UNIQUE INDEX `uk_task_name` (`task_name` ASC) USING BTREE,
UNIQUE INDEX `uk_task_alias` (`task_alias` ASC) USING BTREE
)
COMMENT = '建表模板';
CREATE TABLE `timer_task_execute_param` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
`task_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '任务Id',
`erp_procedure_name` varchar(32) NULL COMMENT 'erp存储过程名称',
`is_multiple_entry` tinyint(1) NULL DEFAULT 0 COMMENT '是否允许在前一次触发尚未执行完时，继续下一次触发',
`is_auto_sync` tinyint(1) NOT NULL DEFAULT 0 COMMENT '开启自动同步',
`repeat_times` int(11) NOT NULL DEFAULT 0 COMMENT '定时器触发任务执行次数，表示该任务触发任务执行的次数, 为0时表示不限制次数',
`pre_task_id` bigint(20) UNSIGNED NULL COMMENT '被依赖的定时任务类型，当本字段不为空时，为链式任务',
`pre_delay` int(11) NOT NULL DEFAULT 0 COMMENT '链式任务的延迟启动时间，单位为mS',
`cron_second` varchar(32) NOT NULL DEFAULT '0' COMMENT '秒值，0-59, 例如： 0表示整分钟, *表示每秒, */10表示每10秒',
`cron_minute` varchar(32) NOT NULL DEFAULT '0' COMMENT '分钟值，0-59, 例如：10表示10分钟，表示每分钟，/20表示每20分钟',
`cron_hour` varchar(32) NOT NULL DEFAULT '0' COMMENT '小时值，0-23，例如：6表示6am，表示每小时，/8表示每8小时',
`cron_dom` varchar(32) NOT NULL DEFAULT '*' COMMENT '日期值，0-30，例如：12表示每月12日，表示每天，/7表示每7天',
`cron_month` varchar(32) NOT NULL DEFAULT '*' COMMENT '月值，例如：3表示3月，表示每个月，/3表示每季度',
`cron_dow` varchar(32) NOT NULL DEFAULT '*' COMMENT '星期值，0-6(0表示星期日)， 例如：2表示星期三，表示每天，/2表示星期一、星期三、星期五',
`start_at` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '定时任务启动时间, epoch格式时间，为0时表示立即启动',
`end_at` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '定时任务停止时间， epoch格式时间，为0时表示永久有效执行',
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_task_id` (`task_id` ASC) USING BTREE
)
COMMENT = '任务执行参数表';
CREATE TABLE `timer_task_callback_param` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
`task_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '任务Id',
`callback_method` varchar(16) NOT NULL DEFAULT 'POST' COMMENT '定时任务触发回调url的方法, GET ,POST ,PUT,DELETE ,PATCH',
`callback_body` text NULL COMMENT '回调参数',
`callback_async` tinyint(1) NOT NULL DEFAULT 1 COMMENT '对于长时间的离线任务，如果超过了TCP超时时间，会被默认中断。所以，当callbackAsync=true时，| 则会返回一个tokenId给业务系统，当任务执行完毕后，将执行状态回调通知Scheduler以保存执行结果',
`callback_url` text NULL COMMENT '定时任务触发时发起的回调url, 当定时器触发时，自动调用callbackUrl，以实现对业务逻辑的定时执行。| 经过url escaping的格式',
`data_receive_url` text NULL COMMENT 'data service 接收数据的回调地址',
`data_notice_url` text NULL COMMENT 'data service 接收回调通知的url',
`callback_content_type` varchar(128) NULL DEFAULT 'application/json' COMMENT '定时任务回调的报文的content-type, 默认为application/json',
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_task_id` (`task_id` ASC)
)
COMMENT = '定时任务回调参数表';

CREATE TABLE `timer_task_template_mapper` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
`if_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
`deleted_at` timestamp NOT NULL DEFAULT 0 COMMENT '删除时间',
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`task_id` bigint(11) UNSIGNED NOT NULL COMMENT '任务 id',
`template_id` bigint(11) UNSIGNED NOT NULL COMMENT '模板 id',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_task_template_id` (`task_id` ,`template_id`,`if_deleted`,`deleted_at` ASC)
)
COMMENT = '模板映射关系';

CREATE TABLE `timer_param_item` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`item_id` bigint(11) UNSIGNED NULL COMMENT '参数模型 id',
`item_key_name` varchar(31) not NULL COMMENT '模型值',
`item_key_param` varchar(31) NOT NULL comment '对应的任务参数的 key',
`template_id` bigint(11) UNSIGNED NULL COMMENT '模板值',
`key_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '启用状态',
`item_reg` varchar(255) NULL COMMENT '属性匹配模板',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_template_id` (`item_id` ASC),
UNIQUE INDEX `uk_titem_key_param` (`item_key_param` ASC),
INDEX `fk_template_id`(`template_id` ASC)
)
COMMENT = '模板主要的 key 值列表';


CREATE TABLE `timer_item_key` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`key_id` bigint(11) UNSIGNED NOT NULL COMMENT '参数值的 id',
`key_name` varchar(31) NOT NULL COMMENT '参数值的值',
`item_id` bigint(11) UNSIGNED NOT NULL COMMENT '模板 id',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uk_key_id` (`key_id` ASC),
INDEX `fk_item_id`(`item_id` ASC)
)
COMMENT = '模板 key 值的 value 的列表';


CREATE TABLE `timer_param_model_param` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`value_id` bigint(11) UNSIGNED NOT NULL COMMENT '参数值的 id',
`value_name` varchar(31) NOT NULL COMMENT '参数值的值',
`key_id` bigint(11) UNSIGNED NOT NULL COMMENT '模板值的匹配值的 id',
`if_defatult` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否默认',
PRIMARY KEY (`id`) 
)
COMMENT = '模板 key 值的 value 的列表';

