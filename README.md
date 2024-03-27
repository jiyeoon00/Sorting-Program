

# Java-Sorting-Program
객체지향(OOP, SOLID), 클린코드를 공부하며 진행한 자바 정렬 프로그램입니다.

사용자는 숫자 또는 단어를 정렬할 수 있으며,   버블 정렬이나 병합 정렬 알고리즘 중에서 선택할 수 있습니다.   또한, 오름차순 또는 내림차순으로 정렬 순서를 지정할 수 있습니다.

<br>  

_**✨프로그램 기능 요약✨**_
1) 사용자는 정렬할 데이터 타입, 정렬 알고리즘, 정렬 순서를 선택합니다.
   - 정렬할 타입(Numbers & Words)
   - 정렬 알고리즘(Bubble Sort & Merge Sort)
   - 정렬 순서(Ascending & Descending)
2) 사용자로부터 정렬할 객체들을 입력받아 정렬합니다.
3) 정렬된 객체를 사용자에게 보여줍니다.

<br>    

## 1️⃣ 클래스 구조도
![image](https://github.com/jiyeoon00/Sorting-Program/assets/77728683/76697b9d-ee7e-480c-8ccc-d753fe5ff18f)

각각의 구성 요소는 다음과 같이 설계되어 있습니다.

➡️ SortingProgram 클래스: 애플리케이션의 메인 플로우를 제어합니다. 사용자로부터 입력을 받아 데이터 타입, 정렬 알고리즘, 정렬 순서를 설정하고, 정렬할 객체들의 배열을 입력받아 정렬 프로세스를 실행합니다. 정렬된 배열은 출력됩니다.

➡️ DataType 인터페이스: 정렬할 데이터 타입을 정의하는 인터페이스입니다. getSortedObjectType 메소드를 통해 정렬할 객체 타입(숫자 또는 단어)을 반환하고, takeObject 메소드는 사용자로부터 해당 타입의 객체를 입력받습니다.

NumberDataType과 WordDataType 클래스: DataType 인터페이스를 구현하는 클래스로, 각각 숫자와 단어 데이터 타입의 입력 및 식별을 담당합니다.

➡️ Sorter 클래스: 정렬 알고리즘의 추상 클래스입니다. 모든 정렬 클래스는 이 클래스를 상속받아 sort 메소드를 구현해야 합니다. setAscendingOrder 메소드를 통해 정렬 순서를 오름차순에서 내림차순으로 변경할 수 있습니다.

BubbleSorter와 MergeSorter 클래스: Sorter 클래스를 상속받아 각각 버블 정렬과 병합 정렬 알고리즘을 구현합니다. sort 메소드는 배열을 정렬하고, 정렬 순서는 Sorter 클래스의 comparator 필드를 사용하여 결정됩니다.

<br>  

## 2️⃣ 전략패턴 적용
전략패턴을 통해 OOP의 5가지 설계원칙인, SOLID를 준수했습니다. 기능을 사용하는 부분과 구현하는 부분을 분리, 캡슐화를 적용함으로써 코드의 유지보수와 확장성을 향상시켰습니다.

<br>  

### 💡전략패턴이란?

정책에 따라 유연하게 동작하는 알고리즘을 캡슐화하여 다형성을 구현하는 디자인 패턴입니다.

<br>  

### 💡어디에 적용이 되었나요?

**1. Sorter 추상클래스**  
정렬 알고리즘을 추상화하여 `Sorter`라는 추상 클래스를 정의합니다. `BubbleSorter`와 `MergeSorter`는 이 추상클래스를 구현하여 구체적인 전략(알고리즘)을 제공합니다.

클라이언트에서는 정렬 알고리즘의 구체적인 구현에 대해 알 필요 없이, `Sorter` 추상클래스를 통해 다양한 정렬 알고리즘을 유연하게 사용할 수 있습니다.

<br>  

**2. DataType 인터페이스**  
정렬될 데이터의 유형을 추상화하여 `DataType` 인터페이스를 정의합니다. 이 인터페이스를 통해 실제 데이터 유형(`NumberDataType`, `WordDataType`)의 구현 세부 사항을 숨기고, 공통의 인터페이스를 통해 다룰 수 있습니다.

클라이언트는 데이터 타입에 대한 구체적인 세부사항을 몰라도 됩니다. 또한 단순히 해당 인터페이스를 구현한 타입 클래스를 추가함으로써, 다른 종류의 데이터 타입도 쉽게 추가할 수 있습니다.

<br>  

### 💡전략패턴을 통해 지켜진 SOLID원칙


1. **단일 책임 원칙(Single Responsibility Principle, SRP)**

각 정렬 알고리즘(`BubbleSorter`, `MergeSorter`)은 자신의 알고리즘을 실행하는 단일 책임을 가집니다.

2. **개방-폐쇄 원칙(Open/Closed Principle, OCP)**

새로운 정렬 알고리즘을 추가할 때 기존 코드를 변경할 필요 없이 `sorter` 추상클래스를 상속받은 새로운 전략 클래스를 추가하기만 하면 됩니다.

3. **리스코프 치환 원칙(Liskov Substitution Principle, LSP)**

`Sorter` 추상 클래스를 구현하는 모든 정렬 알고리즘은 `Sorter`와 대체 가능해야 합니다. 즉, 클라이언트 코드는 구체적인 전략에 대해 알 필요 없이 `Sorter`를 통해 알고리즘을 사용할 수 있습니다.

4. **인터페이스 분리 원칙(Interface Segregation Principle, ISP)**

`Sorter` 추상 클래스는 정렬 알고리즘에 필요한 메소드만을 정의합니다.

5. **의존관계 역전 원칙(Dependency Inversion Principle, DIP)**

클라이언트는 구체적인 정렬 알고리즘(`BubbleSorter`, `MergeSorter`)이 아닌 `Sorter` 추상화에 의존합니다. 이는 고수준 모듈과 저수준 모듈 모두 추상화에 의존하게 하여, 의존관계 역전 원칙을 준수합니다.
