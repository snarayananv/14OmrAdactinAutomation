@BookingHotel
Feature: verfying Adactin Booking Hotel

  Scenario Outline: Verifying Adactin Booking hotel with all valid details
    Given User on the Adactin page
    When User should perform login "<username>" and "<password>"
    Then User should verify after login success message "Hello nitish123!"
    And User should enter all fields in search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<dateCheckIn>","<dateCheckOut>","<adultsPerRoom>" and "<childPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should click Continue select hotel
    Then User should verify select hotel success message "Book A Hotel"
    And User should enter "<firstName>","<lastName>" and "<billingAddress>"
      | ccNumber         | ccType           | expMonth | expYear | cVV |
      | 8765432187654321 | Master Card      | April    |    2017 | 344 |
      | 1234567890123456 | VISA             | December |    2022 | 367 |
      | 8723743187654321 | American Express | March    |    2020 | 398 |
    Then User should verify Booking success message "Booking Confirmation" and save the generated order id

    Examples: 
      | username  | password | location  | hotels         | roomType | noOfRooms | dateCheckIn | dateCheckOut | adultsPerRoom | childPerRoom | firstName | lastName  | billingAddress |
      | nitish123 | V54198   | Melbourne | Hotel Sunshine | Deluxe   | 1 - One   | 20/12/2022  | 21/12/2022   | 2 - Two       | 2 - Two      | Suriya    | Narayanan | 121/64,Rjpm    |

  Scenario Outline: Verifying Adactin Booking hotel without entering any fields
    Given User on the Adactin page
    When User should perform login "<username>" and "<password>"
    Then User should verify after login success message "Hello nitish123!"
    And User should enter all fields in search hotel "<location>","<hotels>","<roomType>","<noOfRooms>","<dateCheckIn>","<dateCheckOut>","<adultsPerRoom>" and "<childPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should click Continue select hotel
    Then User should verify select hotel success message "Book A Hotel"
    And User should click book without entering any details
    Then User should verify after Book hotel with seven error messages "Please Enter your First Name", "Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username  | password | location  | hotels         | roomType | noOfRooms | dateCheckIn | dateCheckOut | adultsPerRoom | childPerRoom |
      | nitish123 | V54198   | Melbourne | Hotel Sunshine | Deluxe   | 1 - One   | 20/12/2022  | 21/12/2022   | 2 - Two       | 2 - Two      |
