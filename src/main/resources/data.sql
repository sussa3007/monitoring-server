insert into `users` (
                     `email`,
                     `username`,
                     `password`,
                     `api_key`,
                     `active`,
                     `authority`
)
values
    (
     'admin@admin.com',
     'admin',
     '{noop}1111!',
     'admin-key-11992873aks',
     1,
     'ADMIN'
    )
;

insert into `user_roles`(`user_id`, `roles`)
values
    (1, 'USER'),
    (1, 'ADMIN')
;