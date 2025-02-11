import SwiftUI

struct SettingsView: View {
    var body: some View {
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }
}

#Preview {
    var model = Model()
    var viwModel = ViewModel(model: model)
    ContentView(selectedTab: 2, viewModel: viwModel)
}
