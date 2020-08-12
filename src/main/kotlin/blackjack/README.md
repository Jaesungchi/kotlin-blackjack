#2단계 - 블랙잭 (step3)

##기능 요구 사항
블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

* 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
* 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
* 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
* 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리한다.
* 게임을 완료한 후 각 플레이어별로 승패를 출력한다.

##기능 구현 목록
[게임 세팅]
1. 게임에 참여할 사람의 목록을 입력받는다. (참여자는 2명 이상 될 수 있다.)
2. 참여자 클래스를 생성한다.
    - 참여자는 이름, 카드 목록을 가진다.
3. 딜러 클래스를 생성한다. 
    - 딜러는 이름(딜러), 카드 목록을 가지며 카드를 받는 예외 룰을 가진다. 
4. 참여자에게 나눠줄 카드 클래스를 생성한다.
  - 카드는 a - k / 스페이드, 하트, 클로버, 다이아 로 구성된다.

[게임 진행]
1. 첫 턴은 카드를 2장씩 나누어 주도록 한다. 
2. 매 턴 카드를 새로 받는 경우 참여자의 카드목록이 출력된다. 
3. 추가로 각 참여자가 카드를 받을 것인지를 선택하는 값을 입력받는다.
4. 단, 참여자의 카드 합이 21을 넘어가는 경우 해당 사용자의 턴은 자동으로 Skip된다.

[게임 결과]
1. 각 사용자의 카드 목록을 print하고 결과를 계산한다.
    - Ace가 1 또는 11로 계산될 수 있는 부분을 고려하여 참여자의 결과에 유리한 방향으로 계산한다. 



##게임 진행 예시
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)  
pobi,jason  

딜러와 pobi, jason에게 2장의 나누었습니다.  
딜러: 3다이아몬드  
pobi카드: 2하트, 8스페이드  
jason카드: 7클로버, K스페이드  

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)  
y  
pobi카드: 2하트, 8스페이드, A클로버  
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)  
n  
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)  
n  
jason카드: 7클로버, K스페이드  
  
딜러는 16이하라 한장의 카드를 더 받았습니다.  
  
딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20  
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21  
jason카드: 7클로버, K스페이드 - 결과: 17  

## 최종 승패
딜러: 1승 1패  
pobi: 승   
jason: 패  