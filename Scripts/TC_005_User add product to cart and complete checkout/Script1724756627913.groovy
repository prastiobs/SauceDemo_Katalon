import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.math.BigDecimal
import java.math.RoundingMode

WebUI.click(findTestObject('Object Repository/Complete Checkout Object/button_Add to cart 1'))

WebUI.click(findTestObject('Object Repository/Complete Checkout Object/button_Add to cart 2'))

WebUI.click(findTestObject('Object Repository/Complete Checkout Object/a_1'))

WebUI.click(findTestObject('Object Repository/Complete Checkout Object/button_Checkout'))

WebUI.setText(findTestObject('Object Repository/Complete Checkout Object/input_firstName'), firstName)

WebUI.setText(findTestObject('Object Repository/Complete Checkout Object/input_lastName'), lastName)

WebUI.setText(findTestObject('Object Repository/Complete Checkout Object/input_postalCode'), postalCode)

WebUI.click(findTestObject('Object Repository/Complete Checkout Object/input_continue'))

//Get Price Text
def priceProduct1Text = WebUI.getText(findTestObject('Object Repository/Complete Checkout Object/div_29.99'))
def priceProduct2Text = WebUI.getText(findTestObject('Object Repository/Complete Checkout Object/div_9.99'))
def totalPriceText = WebUI.getText(findTestObject('Object Repository/Complete Checkout Object/div_Item total 39.98'))
def totalPriceTextAfterTax = WebUI.getText(findTestObject('Object Repository/Complete Checkout Object/div_Total 43.18'))

//String to number conversion
double priceProduct1 = Double.parseDouble(priceProduct1Text.replaceAll("[^\\d.]", ""))
double priceProduct2 = Double.parseDouble(priceProduct2Text.replaceAll("[^\\d.]", ""))
double totalPrice = Double.parseDouble(totalPriceText.replaceAll("[^\\d.]", ""))
double totalPriceAfterTax = Double.parseDouble(totalPriceTextAfterTax.replaceAll("[^\\d.]", ""))

//Calculate total price include tax
double expectedTotal = priceProduct1 + priceProduct2
double taxRate = 0.08 // Pajak 8%
BigDecimal totalWithTax = expectedTotal * (1 + taxRate)
totalWithTaxRound = totalWithTax.setScale(2, RoundingMode.HALF_UP)

//Verify total price before tax
WebUI.verifyEqual(totalPrice, expectedTotal)

//Verify total price with tax
WebUI.verifyEqual(totalPriceAfterTax, totalWithTaxRound)

WebUI.click(findTestObject('Object Repository/Complete Checkout Object/button_Finish'))

//define
def testObject = findTestObject('Object Repository/Complete Checkout Object/Complete Checkout')

//assertion
WebUI.verifyElementPresent(testObject, 10)

WebUI.closeBrowser()

