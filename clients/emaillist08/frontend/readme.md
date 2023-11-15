# Emaillist: Frontend

1.  설치
    1)  개발툴
        $ npm i -D webpack webpack-cli webpack-dev-server css-loader style-loader sass-loader node-sass babel-loader @babel/core @babel/preset-env @babel/preset-react case-sensitive-paths-webpack-plugin @babel/plugin-transform-runtime @babel/plugin-syntax-throw-expressions
    2)  라이브러리
        $ npm i react react-dom prop-types

2.  설정
    1)  webpack.config.js
    2)  babel.config.json

3.  스트립팅
    "scripts": {
    "debug": "npx webpack serve --config config/webpack.config.js --progress --mode development",
    "build": "npx webpack --config config/webpack.config.js --mode production"
}

4.  테스트 서버 실행
    $ npm run debug 






-------------------------

1.  backend
    1)  테스트(개발 모드)
        eclipse ctrl+f11 (스프링부트 애플리케이션 실행)

    2)  빌드(서버배포)
        # mvn -f emaillist/backend exec:exec clean package

    3)  빌드(서버배포) 테스트
        # java -Dspring.profiles.active=production -jar emaillist/backend/target/emaillist.jar 

2. frontend


3-1. deploy: ssh 연결(ssh key 인증)
    1) key 생성하기
         ssh-keygen -t rsa -b 2048 -m PEM -C "cheerup313@naver.com"
    2) key 생성 확인
       1) private key(개인키) : ~/.ssh/id_rsa
       2) public key(공개키) : ~/.ssh/id_rsa.pub
    3) 공개키를 서버에 설치하기
       1) mv ~/.ssh/id_rsa.pub ~/.ssh/authorized_keys
    4) private key 잘 저장하기
   
    5) 접속 테스트
        # ssh -i mykey.pem root@192.168.0.92
    6) 접속 연결
        1) ~/.ssh/environment
          ==================
          PATH=/usr/local/poscodx2023/java/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/local/poscodx2023/git/bin:/usr/local/poscodx2023/maven/bin:/usr/local/poscodx2023/mariadb/bin:/usr/local/poscodx2023/tomcat:/root/bin

        ====================
        2) /etc/ssh/sshd_config
            PermitUserEnvirionment yes
            

3-2. deploy: Publish Over SSH 플러그인(Jenkins)
1) Public Over SSH 플러그인 설치
2) Dashboard > Jenkins 관리 > System
   1) 실행서버(ssh Server) 등록 : springboot-publish-server
   2) 프로젝트의 빌드 후 조치(post-build action)의 send build artifacts over ssh설정
      1) emaillist.jar: transfer
      2) launch.sh: transfer +execution 