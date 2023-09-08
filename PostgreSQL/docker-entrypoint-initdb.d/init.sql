-- Создаем базу данных
CREATE DATABASE mydatabase;

-- Создаем пользователя и устанавливаем пароль
CREATE USER myuser WITH ENCRYPTED PASSWORD 'mypassword';

-- Даем пользователю права на базу данных
GRANT ALL PRIVILEGES ON DATABASE mydatabase TO myuser;