# 안드로이드 Room 라이브러리 스터디

이 레포지토리는 안드로이드 Room 라이브러리에 대한 스터디를 위한 공간입니다. 이 스터디를 통해 Room 라이브러리에 대한 기본 개념을 이해하고 실제 프로젝트에서의 활용 능력을 향상시킬 수 있습니다.

## 스터디 목표

- Room 라이브러리의 주요 개념 및 기능 숙지
- 간단한 안드로이드 앱에 Room 라이브러리를 통합하는 경험 쌓기
- 실무에서의 활용 가능한 Room 라이브러리 사용 능력 향상

## 스터디 방법

1. 매주 새로운 주제를 정하고 해당 주제에 대한 이론 공부를 진행합니다.
2. 이론을 바탕으로 주제에 대한 실습을 클론 코딩, 백지 코딩, 변형 코딩 순으로 진행합니다.
3. `topic/주제명` 브랜치에서 순서대로 클론 코딩, 백지 코딩, 변형 코딩 브랜치를 생성, Pull Requset를 반복합니다.
4. 가급적 공식 문서에 의존하여 클론 코등일 작성합니다. 이때 Pull Request의 라벨은 `clone coding`입니다.
5. 클론 코딩한 내용을 기억에 의존하여 처음부터 다시 작성합니다. 이때 Pull Request의 라벨은 `black review`입니다.
6. 코드 실습을 통해 얻은 경험과 이해를 바탕으로 기능을 변형하여 작성합니다. 이때 Pull Request의 라벨은 `practice`입니다.

## 스터디 일정

- **주 1회**: 새로운 주제에 대한 이론 공부 및 간단한 코딩 실습

## 브랜치 및 커밋 관리

- 각 주제나 기능 단위로 브랜치를 생성합니다. 브랜치 이름은 `topic/주제명` 형식을 따릅니다.
- 커밋 메시지는 명확하고 간결하게 작성합니다. 주로 다음과 같은 형식을 따릅니다:
  - `feat: 새로운 기능 추가`
  - `fix: 버그 수정`
  - `docs: 문서 업데이트`
  - `refactor: 코드 리팩토링`
  - `test: 테스트 코드 추가/수정`
  - `chore: 빌드 및 설정 파일 업데이트`
- 토픽의 종류는 sqlite와 room 두가지가 있습니다.
- 생성된 `topic/주제명` 브랜치에서 `topci/주제명/#이슈번호` 브랜치를 생성해서 작업이 끝나면 `topic/주제명` 브랜치에 Pull Request합니다.

예시: `sqlite/create-the-database` `room/create-the-database`
예시: `git commit -m "feat: Implement data access object for user entity"`

## Pull Request 규칙

- Pull Request를 생성하기 전에 코드를 리뷰하고 자신이 작업한 내용에 대해 확인합니다.
- Pull Request 제목은 간결하고 명확하게 작성하고, 본문에 변경 사항을 자세히 기록합니다.
- Pull Request의 제목은 영어와 한글 상관 없이 작성합니다.
- Pull Request의 제목의 영단어는 모두 대문자로 시작하도록 합니다.
- 만약 이슈가 있으면 해당 이슈 번호를 제목에 추가합니다.
- 학습 내용과 리뷰는 `clone coding`과 `blank review`이 아닌 `practice` 이슈와 pull request에 작성합니다.

예시: `[blank review]: SQLite API를 사용한 Database 생성 기능을 구현한다`

## 개발 환경
```
Language: Kotlin
IDE: Android Studio Hedgehog
compile SDK: 33
```
---
## 참고 자료

- [공식 Android Developers 문서](https://developer.android.com/training/data-storage/room)
- [좋은 코드 작성을 위한 안드로이드 아키텍처 가이드](https://developer.android.com/jetpack/guide)
- [Room Persistence 라이브러리 공식 GitHub](https://github.com/android/architecture-components-samples/tree/main/BasicSample)
- [뷰를 사용한 Android Room - Kotlin](https://developer.android.com/codelabs/android-room-with-a-view-kotlin?hl=ko#0)
