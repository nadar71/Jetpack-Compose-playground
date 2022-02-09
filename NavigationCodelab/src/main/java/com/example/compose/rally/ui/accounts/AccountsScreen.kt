
package com.example.compose.rally.ui.accounts

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.rally.R
import com.example.compose.rally.data.Account
import com.example.compose.rally.data.UserData
import com.example.compose.rally.ui.bills.BillsBody
import com.example.compose.rally.ui.components.AccountRow
import com.example.compose.rally.ui.components.StatementBody
import com.example.compose.rally.ui.theme.RallyTheme

/**
 * The Accounts screen.
 */
@Composable
fun AccountsBody(
    accounts: List<Account>,
    onAccountClick: (String) -> Unit = {},
) {
    StatementBody(
        modifier = Modifier.semantics { contentDescription = "Accounts Screen" },
        items = accounts,
        amounts = { account -> account.balance },
        colors = { account -> account.color },
        amountsTotal = accounts.map { account -> account.balance }.sum(),
        circleLabel = stringResource(R.string.total),
        rows = { account ->
            AccountRow(
                modifier = Modifier.clickable {
                    onAccountClick(account.name)
                },
                name = account.name,
                number = account.number,
                amount = account.balance,
                color = account.color
            )
        }
    )
}

/**
 * Detail screen for a single account.
 */
@Composable
fun SingleAccountBody(account: Account) {
    StatementBody(
        items = listOf(account),
        colors = { account.color },
        amounts = { account.balance },
        amountsTotal = account.balance,
        circleLabel = account.name,
    ) { row ->
        AccountRow(
            name = row.name,
            number = row.number,
            amount = row.balance,
            color = row.color
        )
    }
}


// -------------------------------- PREVIEWS ---------------------------------------------
@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun AccountsBodyPreview() {
    RallyTheme{
        AccountsBody(UserData.accounts)
    }
}