# JWT

## JWT 란 ?

- JSON Web Token 의 약자로 토큰 기반의 인증 (Claim Base Token)
- 웹표준(RFC7519)으로서 두 개체에서 JSON 객체를 사용하여 가볍고 자가수용적인(self-contained) 방식으로 정보를 안전성있게 전달해준다.
- 즉, 토큰 자체가 정보를 가지고 있는 방식

## JWT 목적

- 두 개체 사이에 안전하게 claim을 전송하는것
- claim 이란 사용자에 대한 프로퍼티나 속성을 뜻한다.

## JWT 장점

- 수많은 프로그래밍 언어에서 지원 : C, Java, Python, C++, R, C#, PHP, JavaSript, Ruby...
- 자가 수용적(self-contained) : 모든 정보를 토큰 자체에 포함하기 때문에 별도의 인증 저장소가 필요없다.
- 쉽게 전달 될 수 있습니다.

## JWT Structure

- 헤더 (Header)
- 페이로드(Payload)
- 시그너처(Signature)

## Reference

- https://jwt.io/
- https://velopert.com/2389
- http://www.opennaru.com/opennaru-blog/jwt-json-web-token/
