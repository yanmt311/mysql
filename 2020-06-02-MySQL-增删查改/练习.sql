create table exam_result (
  id int,
  name varchar(200),
  chinese double,
  math double,
  english double
);


insert into exam_result values
  (1, '唐三藏', 67, 98, 56),
  (2, '孙悟空', 87.5, 78, 77),
  (3, '猪悟能', 88, 98.5, 90),
  (4, '曹孟德', 82, 84, 67),
  (5, '刘玄德', 55.5, 85, 45),
  (6, '孙权', 70, 73, 78.5),
  (7, '宋公明', 75, 65, 30);
  
-- 开头，代表 sql 中注释
-- 查询 exam_result 所有数据行的所有列
select * from exam_result;


-- 查询 所有行，但只需要给出 name 列
select name from exam_result;

select id, name, 10 from exam_result;

select name, chinese + math + english from exam_result;

select name, chinese + math + english as total from exam_result;
select name, chinese + math + english total from exam_result;

select distinct math from exam_result;

select english > 60 from exam_result;

select * from exam_result where english > chinese;

select * from exam_result where english = 77;

select * from exam_result where english != 77; 

select * from exam_result where name = '唐三藏';

select * from exam_result where name != '唐三藏';

select * from exam_result where english > 60;

-- 查询英语成绩在 [67, 100] 左闭右闭，包含 67 和 100
select * from exam_result where english between 67 and 100;

select * from exam_result where english >= 67 and english <= 100;

-- 查询孙悟空、唐三藏的成绩
select * from exam_result where name in ('孙悟空', '唐三藏');

select * from exam_result where name = '孙悟空' or name = '唐三藏';

-- 查询除了孙悟空、唐三藏的成绩
select * from exam_result where name not in ('孙悟空', '唐三藏');

select * from exam_result where not (name = '孙悟空' or name = '唐三藏');

select * from exam_result where name != '孙悟空' and name != '唐三藏';

-- 查询已经登记过 qq 邮箱的同学
select * from student where qq_mail != null;           -- 错误
select * from student where null;                      -- 错误

select * from student where qq_mail is not null;       -- 正确

-- 查询没有登记过 qq 邮箱的同学
select * from student where qq_mail = null;            -- 错误
select * from student where null;                      -- 错误

select * from student where qq_mail is null;           -- 正确  鼓励使用这种方法
select * from student where qq_mail <=> null;          -- 正确  看到认识即可

-- 查询某个同学的成绩，条件是，该同学姓孙
select * from exam_result where name like '孙%';
-- % 代表
--   0个或者多个字符                  数目待定
--   如果出现，可以是任意字符         字符待定

-- 查询某个同学的成绩，条件是，该同学叫“什么孙”
select * from exam_result where name like '%孙';

-- 查询某个同学的成绩，条件是，该同学名字中带“孙”
select * from exam_result where name like '%孙%';

-- 查询某个同学的成绩，条件是，该同学叫“孙某”
select * from exam_result where name like '孙_';

-- 查询某个同学的成绩，条件是，该同学叫“孙某某”
select * from exam_result where name like '孙__';

-- 查询同学的成绩，条件是，同学不叫“孙某某”
select * from exam_result where name not like '孙__';













