# 미션 - 페어매칭관리 애플리케이션

## 기능 구현 목록

- [x] 우테코에서 운영하는 과정에 따른 Enum 작성하기
    - [x] 2과정 -> 각 5레벨 -> 각 미션들로 나누어 작성하기 Course#, Level#
- [x] 페어 매칭에 필요한 크루들의 이름을 파일 입출력을 통해 불러오는 기능 구현 FileManager#loadCrewFromFile
    - [x] `src/main/resources/backend-crew.md`과 `src/main/resources/frontend-crew.md` 파일을 이용하기
- [x] 기능선택
    - [x] 기능의 종류를 출력하고 그 중 하나의 입력을 받기 InputView#getFunctionMenu
        - [x] 빈값 검사
        - [x] 길이 검사 (1글자만 입력)
        - [x] 주어진 메뉴 중 1개 인지 검사
- [ ] 페어 매칭 조건
    - [x] 미션을 함께 수행할 페어를 두명씩 매칭
        - [ ] 미션을 시작하기 전 페어를 매칭하는데 다양한 페어를 만나기 위해서 같은 레벨 동안은 같은 페어를 만나지 않기
            - [ ] 같은 레벨에서 이미 페어를 맺은 크루와는 다시 페어로 매칭될 수 없도록 하기
        - [x] 페어 매칭 대상이 홀수인 경우 한 페어는 3인으로 구성
- [x] 페어 매칭 구현
    - [x] 과정와 미션을 출력하고 매칭하고자 하는 과정, 레벨, 미션을 입력 받기 InputView#getMatchingInfo
    - [x] 크루들의 이름 목록을 List<String> 형태로 준비하여 크루 목록의 순서를 랜덤으로 섞기. PairMachine#getShuffledCrews
        - 이 때 `camp.nextstep.edu.missionutils.Randoms`의 shuffle 메서드를 활용
    - [x] 랜덤으로 섞인 페어 목록에서 페어 매칭을 할 때 앞에서부터 순서대로 두명씩 페어를 맺기
    - [x] 홀수인 경우 마지막 남은 크루는 마지막 페어에 포함시키기
    - [ ] 같은 레벨에서 이미 페어로 만난적이 있는 크루끼리 다시 페어로 매칭 된다면 크루 목록의 순서를 다시 랜덤으로 섞어서 매칭을 시도하기
    - [ ] 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러 메시지를 출력하기
- [x] 페어 재매칭 시도
    - [x] 안내 문구를 출력 후 매칭을 진행하기
    - [x] 아니오를 선택할 경우 코스, 레벨, 미션을 다시 선택하기
- [x] 페어 조회 기능
    - [x] 과정, 레벨, 미션을 선택하면 해당 미션의 페어 정보를 출력하기
    - [x] 매칭 이력이 없으면 매칭 이력이 없다고 안내하기
- [x] 페어 초기화 기능 구현
