KioskLv1 : Scanner, 조건문, 반복문을 활용하여 햄버거 메뉴 출력 및 선택하는 Main class 작성

KioskLv2 : 이름, 가격, 설명 필드를 갖고  개별 햄버거 항목을 관리하는 menuItem class 작성 / Main class에서 MenuItem 객체 생성을 통해 이름, 가격, 설명을 세팅 -> menuItemList를 선언하여 여러 MenuItem을 추가 -> 반복문을 활용해 menuItemList 안에 있는 MenuItem을 하나씩 출력
-> 숫자를 입력 받기 -> 입력된 숫자에 따른 처리 -> 선택한 메뉴 : 이름, 가격, 설명 -> 프로그램을 종료

KioskLv3 : MenuItem을 관리하는 menuItemList가 필드로 존재하는 Kiosk class 생성 -> main 함수에서 관리하던 입력과 반복문 로직은 Kiosk class에서 start 함수를 만들어 관리 -> menuItemList는 Main class에서 Kiosk class 생성자를 통해 값을 할당 -> 유효하지 않은 입력에 대해 오류 메시지를 출력하는 예외처리와
`0`을 입력하면 프로그램이 ‘종료’되는 기능 추가

KioskLv4,5 : 여러 버거들을 포함하는 상위 개념 ‘버거’ 같은 카테고리 이름 필드를 갖고 Lv3에서 kiosk가 관리하던 menuItemList가 옮겨진 Menu class를 생성 -> 메뉴 카테고리 이름을 반환하는 메서드 getCategoryName(), menuItemList 전체를 출력하는 메서드 printMenuItemList() 구현 -> Main class에서 Menu 객체 생성하면서 카테고리 이름 설정 -> Menu 클래스 내 있는 menuItemList 에 MenuItem 객체 생성하면서 삽입 -> Kiosk class 필드에 Menu 타입의 클래스를 요소로하는 List인 categoryList를 생성 -> Main class에서 생성된 MenuItem 객체가 들어간 이름이 설정된 Menu 클래스를 categoryList에 추가 -> category리스트와 반복문을 사용하여 category 전체 출력 -> 숫자입력을 받고 categoryList의 index를 통하여 menuItemList에 접근, 전체 리스트 출력 -> 예외처리와 예외처리 후 다시 번호 선택을 하도록 반복 -> 올바른 번호 입력시 menuItemList 출력 후 menuItem선택 번호 입력 -> 예외처리와 예외처리 후 다시 번호 선택을 하도록 반복 -> 올바른 번호 입력시 주문처리 ->(Lv5) MenuItem, Menu 그리고 Kiosk 클래스의 필드에 직접 접근하지 못하도록 캡슐화 -> Main class를 제외한 모든 class에 Getter와 Setter 메서드를 사용해 데이터를 관리

KioskChalLv1 : 사용자가 선택한 메뉴를 장바구니에 추가할 수 있게 하기 위해 Cart class를 생성, 사용자가 주문을 위해 선택한 물품 데이터를 주문하기까지 보관하는 List인 cart와 장바구니에서 뺀 물품을 개별로 시각화 하고 장바구니 취소를 철회하거나 한번에 취소물품의 데이터를 제거하기 위한 cancelList를 생성 ->  각 cart와 cancelLIst의 정보를 반환, 추가, 설정, 제거, 출력하는 메서드를 생성 -> 장바구니 물품을 적절히 다듬어 출력하고 장바구니의 물품을 합산하여 총 금액을 계산하여 주문정보를 제공하기 위해 Order class를 생성 -> orderList를 생성하고 cart(장바구니리스트) 전체를 addAll 함수를 이용하여 추가 -> orderList를 반환, 설정, 출력, 리스트 전체의 가격을 합산하여 값을 반환하는 메서드를 생성 -> 장바구니는 사용자가 물품 선택시 주문하기전까지 상시 출력되며, 취소하기 기능은 cancelList와 cart 상호 작용하며 사용자가 최종 제거할 물품을 선정하게한다. -> start 함수의 여러 출력 로직들을 빼서 메서드로 관리

KioskChalLv2 : 사용자 유형의 Enum 정의 및 각 사용자 유형에 따른 할인율 적용을 위한 Discount Enum을 생성 -> Discount 각 상수는 (code, 할인률, 할인함수)를 필드로 갖는다. -> 상수의 코드를 반환하는 메서드, 매개변수인 정수에 따라 이넘 상수 클래스를 반환하는 메서드, 매개변수인 정수와 가격에 따른 할인 가격을 반환하는 메서드를 생성 -> Kiosk class에 할인이 적용된 주문 프로세스를 출력해주는 메서드를 생성 -> 모든 리스트 출력을 위한 향상된 for문을 stream().forEach()문으로 변경 -> Stream 내에서 index 출력을 위해 AtomicInteger 객체를 생성
