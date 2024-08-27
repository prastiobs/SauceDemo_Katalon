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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://saucelabs.com/sign-up')

WebUI.click(findTestObject('Object Repository/Signup Object/a_img altAuthenticate with Email srcSetsign_72abec'))

WebUI.setText(findTestObject('Object Repository/Signup Object/input_email'), 'standar_usergmail.com')

WebUI.setText(findTestObject('Object Repository/Signup Object/input_username'), 
    'standard_user')

WebUI.setEncryptedText(findTestObject('Object Repository/Signup Object/input_password'), 
    'iFGeFYmXIrWFQK9cz/KNiQ==')

WebUI.click(findTestObject('Object Repository/Signup Object/input_contactConsent'))

WebUI.click(findTestObject('Object Repository/Signup Object/button_Sign up'))

//assertion
WebUI.verifyElementText(findTestObject('Object Repository/Signup Object/p_Not a valid email format'), 'Not a valid email format')

WebUI.closeBrowser()

