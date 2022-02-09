
package com.example.compose.rally.ui.bills

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.rally.R
import com.example.compose.rally.RallyApp
import com.example.compose.rally.data.Bill
import com.example.compose.rally.data.UserData
import com.example.compose.rally.ui.components.BillRow
import com.example.compose.rally.ui.components.StatementBody
import com.example.compose.rally.ui.theme.RallyTheme

/**
 * The Bills screen.
 */
@Composable
fun BillsBody(bills: List<Bill>) {
    StatementBody(
        modifier = Modifier.clearAndSetSemantics { contentDescription = "Bills" },
        items = bills,
        amounts = { bill -> bill.amount },
        colors = { bill -> bill.color },
        amountsTotal = bills.map { bill -> bill.amount }.sum(),
        circleLabel = stringResource(R.string.due),
        rows = { bill ->
            BillRow(bill.name, bill.due, bill.amount, bill.color)
        }
    )
}


// -------------------------------- PREVIEWS ---------------------------------------------
@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun BillsBodyPreview() {
    RallyTheme{
        BillsBody(UserData.bills)
    }
}
