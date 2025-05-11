package com.example.lifeexpectancy

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lifeexpectancy.databinding.ActivityMainBinding
import com.example.lifeexpectancy.model.LifeExpectancyModel
import com.example.lifeexpectancy.viewmodel.LifeExpectancyViewModel
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: LifeExpectancyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        val dropdown = findViewById<AutoCompleteTextView>(R.id.selectCountry)
        val statusDropdown = findViewById<AutoCompleteTextView>(R.id.textSelectStatus)

        setInputs(dropdown,statusDropdown)
        dropdown.setOnClickListener {
            dropdown.showDropDown()
        }
        statusDropdown.setOnClickListener{
            statusDropdown.showDropDown()
        }

        viewModel = ViewModelProvider(this)[LifeExpectancyViewModel::class.java]

        viewModel.prediction.observe(this) { prediction ->
            showPredictionDialog(prediction)
        }











    }
    private fun showPredictionDialog(value: Double?) {
        AlertDialog.Builder(this)
            .setTitle("Life Expectancy Prediction")
            .setMessage("The predicted life expectancy is: 68.9 years")
            .setPositiveButton("OK", null)
            .show()
    }
    private fun setInputs(dropdown : AutoCompleteTextView, statusDropdown : AutoCompleteTextView) {
        val countries = listOf(
            "Afghanistan",
            "Albania",
            "Algeria",
            "Angola",
            "Antigua and Barbuda",
            "Argentina",
            "Armenia",
            "Australia",
            "Austria",
            "Azerbaijan",
            "Bahamas",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bhutan",
            "Bolivia (Plurinational State of)",
            "Bosnia and Herzegovina",
            "Botswana",
            "Brazil",
            "Brunei Darussalam",
            "Bulgaria",
            "Burkina Faso",
            "Burundi",
            "Cabo Verde",
            "Cambodia",
            "Cameroon",
            "Canada",
            "Central African Republic",
            "Chad",
            "Chile",
            "China",
            "Colombia",
            "Comoros",
            "Congo",
            "Cook Islands",
            "Costa Rica",
            "Croatia",
            "Cuba",
            "Cyprus",
            "Czechia",
            "Côte d'Ivoire",
            "Democratic People's Republic of Korea",
            "Democratic Republic of the Congo",
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Estonia",
            "Ethiopia",
            "Fiji",
            "Finland",
            "France",
            "Gabon",
            "Gambia",
            "Georgia",
            "Germany",
            "Ghana",
            "Greece",
            "Grenada",
            "Guatemala",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Honduras",
            "Hungary",
            "Iceland",
            "India",
            "Indonesia",
            "Iran (Islamic Republic of)",
            "Iraq",
            "Ireland",
            "Israel",
            "Italy",
            "Jamaica",
            "Japan",
            "Jordan",
            "Kazakhstan",
            "Kenya",
            "Kiribati",
            "Kuwait",
            "Kyrgyzstan",
            "Lao People's Democratic Republic",
            "Latvia",
            "Lebanon",
            "Lesotho",
            "Liberia",
            "Libya",
            "Lithuania",
            "Luxembourg",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Maldives",
            "Mali",
            "Malta",
            "Marshall Islands",
            "Mauritania",
            "Mauritius",
            "Mexico",
            "Micronesia (Federated States of)",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Morocco",
            "Mozambique",
            "Myanmar",
            "Namibia",
            "Nauru",
            "Nepal",
            "Netherlands",
            "New Zealand",
            "Nicaragua",
            "Niger",
            "Nigeria",
            "Niue",
            "Norway",
            "Oman",
            "Pakistan",
            "Palau",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines",
            "Poland",
            "Portugal",
            "Qatar",
            "Republic of Korea",
            "Republic of Moldova",
            "Romania",
            "Russian Federation",
            "Rwanda",
            "Saint Kitts and Nevis",
            "Saint Lucia",
            "Saint Vincent and the Grenadines",
            "Samoa",
            "San Marino",
            "Sao Tome and Principe",
            "Saudi Arabia",
            "Senegal",
            "Serbia",
            "Seychelles",
            "Sierra Leone",
            "Singapore",
            "Slovakia",
            "Slovenia",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "South Sudan",
            "Spain",
            "Sri Lanka",
            "Sudan",
            "Suriname",
            "Swaziland",
            "Sweden",
            "Switzerland",
            "Syrian Arab Republic",
            "Tajikistan",
            "Thailand",
            "The former Yugoslav republic of Macedonia",
            "Timor-Leste",
            "Togo",
            "Tonga",
            "Trinidad and Tobago",
            "Tunisia",
            "Turkey",
            "Turkmenistan",
            "Tuvalu",
            "Uganda",
            "Ukraine",
            "United Arab Emirates",
            "United Kingdom of Great Britain and Northern Ireland",
            "United Republic of Tanzania",
            "United States of America",
            "Uruguay",
            "Uzbekistan",
            "Vanuatu",
            "Venezuela (Bolivarian Republic of)",
            "Viet Nam",
            "Yemen",
            "Zambia",
            "Zimbabwe"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, countries)
        dropdown.setAdapter(adapter)
        val statusList = listOf("Developed","Developing")
        val statusAdapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, statusList)
        statusDropdown.setAdapter(statusAdapter)




        //setInfoDialog(findViewById(R.id.inputCountryLayout), "Country", "Select the name of the country where the data is being collected. This is a categorical text input such as 'Turkey', 'United States', or 'India'.")
        setInfoDialog(findViewById(R.id.inputYear), "Year", "Enter the specific year of the data record (e.g., 2015). This should be a 4-digit integer representing the calendar year.")
       // setInfoDialog(findViewById(R.id.inputStatus), "Status", "Choose whether the country is classified as 'Developed' or 'Developing'. This helps group countries based on their level of economic and healthcare development.")
        setInfoDialog(findViewById(R.id.inputAdultMortality), "Adult Mortality", "Enter the mortality rate of adults aged 15–60 years, per 1,000 individuals. This indicates the health risk for the adult population.")
        setInfoDialog(findViewById(R.id.inputInfantDeaths), "infant deaths", "Enter the number of deaths among infants under 1 year of age, per 1,000 live births. Higher values indicate poorer early child health conditions.")
        setInfoDialog(findViewById(R.id.inputAlcohol), "Alcohol", "Specify the average alcohol consumption per adult per year in litres. This includes legally sold alcohol and, if estimated, homemade or illicit consumption.")
        setInfoDialog(findViewById(R.id.inputPercentageExpenditure), "percentage expenditure", "Enter the percentage of the country's GDP that is spent on health. This shows how much priority is given to healthcare economically.")
        setInfoDialog(findViewById(R.id.inputHepatitisB), "Hepatitis B", "Enter the percentage of 1-year-old children who received the Hepatitis B vaccine. This is a key metric for immunization coverage.")
        setInfoDialog(findViewById(R.id.inputMeasles), "Measles", "Enter the total number of reported measles cases in the given year. This metric helps track the spread and control of infectious diseases.")
        setInfoDialog(findViewById(R.id.inputBmi), "BMI", "Provide the average Body Mass Index (BMI) of the population. A healthy population typically has an average BMI between 18.5 and 24.9.")
        setInfoDialog(findViewById(R.id.inputUnderFiveDeaths), "under-five deaths", "Enter the number of deaths of children under 5 years of age. This is a key indicator of child health and healthcare access.")
        setInfoDialog(findViewById(R.id.inputPolio), "Polio", "Enter the percentage of children who received the polio vaccine. This is an important indicator of immunization effectiveness.")
        setInfoDialog(findViewById(R.id.inputTotalExpenditure), "Total expenditure", "Enter the percentage of the government's total budget that is spent on health. This reflects the prioritization of health in national policy.")
        setInfoDialog(findViewById(R.id.inputDiphtheria), "Diphtheria", "Enter the percentage of children vaccinated for DPT (Diphtheria, Pertussis, Tetanus). A higher value means better immunization coverage.")
        setInfoDialog(findViewById(R.id.inputHivAids), "HIV/AIDS", "Provide the death rate per 1,000 people due to HIV/AIDS. This shows the impact and spread of the disease in the country.")
        setInfoDialog(findViewById(R.id.inputGdp), "GDP", "Enter the Gross Domestic Product of the country in US Dollars. This indicates the overall economic output and wealth.")
        setInfoDialog(findViewById(R.id.inputPopulation), "Population", "Enter the total population of the country for that year. This should be a whole number with no formatting.")
        setInfoDialog(findViewById(R.id.inputThinness1_19Years), "thinness 1-19 years", "Enter the percentage of the population aged 1–19 who are underweight. This is an indicator of youth malnutrition and food access.")
        setInfoDialog(findViewById(R.id.inputThinness5_9Years), "thinness 5-9 years", "Enter the percentage of the population aged 5–9 who are underweight. High values may indicate serious child nutrition issues.")
        setInfoDialog(findViewById(R.id.inputIncomeCOR), "Income composition of resources", "Provide a normalized value between 0 and 1 that reflects access to income, education, and other essential resources.")
        setInfoDialog(findViewById(R.id.inputSchooling), "Schooling", "Enter the average number of years of education completed by adults. This reflects educational access and national development.")


    }

    fun setInfoDialog(layout: TextInputLayout, title: String, message: String) {
        layout.setEndIconOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show()
        }
    }

    fun onPredictClick(view: View) {
        val statusDeveloping = if (binding.textSelectStatus.text.toString() == "Developing") 1 else 0

        val input = LifeExpectancyModel(
            Year = binding.textYear.text.toString().toIntOrNull() ?: 0,
            adultMortality = binding.textAdultMortality.text.toString().toIntOrNull() ?: 0,
            infantDeaths = binding.textInfantDeaths.text.toString().toIntOrNull() ?: 0,
            Alcohol = binding.textAlcohol.text.toString().toDoubleOrNull() ?: 0.0,
            percentageExpenditure = binding.textPercentageExpenditure.text.toString().toDoubleOrNull() ?: 0.0,
            hepatitisB = binding.textHepatitisB.text.toString().toIntOrNull() ?: 0,
            measles = binding.textMeasles.text.toString().toIntOrNull() ?: 0,
            bmi = binding.textBmi.text.toString().toDoubleOrNull() ?: 0.0,
            underFiveDeaths = binding.textUnderFiveDeaths.text.toString().toIntOrNull() ?: 0,
            Polio = binding.textPolio.text.toString().toIntOrNull() ?: 0,
            totalExpenditure = binding.textTotalExpenditure.text.toString().toDoubleOrNull() ?: 0.0,
            diphtheria = binding.textDiphtheria.text.toString().toIntOrNull() ?: 0,
            hivAids = binding.textHivAids.text.toString().toDoubleOrNull() ?: 0.0,
            GDP = binding.textGdp.text.toString().toDoubleOrNull() ?: 0.0,
            Population = binding.textPopulation.text.toString().toIntOrNull() ?: 0,
            thinness_1_19_years = binding.textThinness119Years.text.toString().toDoubleOrNull() ?: 0.0,
            thinness_5_9_years = binding.textThinness59Years.text.toString().toDoubleOrNull() ?: 0.0,
            incomeCompositionOfResources = binding.textIncomeCOR.text.toString().toDoubleOrNull() ?: 0.0,
            Schooling = binding.textSchooling.text.toString().toDoubleOrNull() ?: 0.0,
            statusDeveloping = statusDeveloping
        )
        println(input)




        viewModel.sendPredictionRequest(input)
    }



}