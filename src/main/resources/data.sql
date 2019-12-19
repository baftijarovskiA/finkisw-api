-- Creating default roles
INSERT INTO `app_role`(`id`, `description`, `role_name`) VALUES
    (1,'Administrator privileges and rights!','ADMIN_USER'),
    (2,'Teacher privileges and rights!','TEACHER_USER'),
    (3,'Student privileges and rights!','STUDENT_USER');

-- Creating admin user
-- password = 'pwadmin'
INSERT INTO `app_user`(`id`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES (1,'baftijary@gmail.com','Admin','FinkiSW','$2a$10$c2sPNXfbYnkXJWMYDGAGuOePeBgKmMGcfvVrZ7cYbKYoVNgcBBkju','admin');

-- Setting admin user to ADMIN_USER role
INSERT INTO `user_role`(`user_id`, `role_id`) VALUES ('1','1');