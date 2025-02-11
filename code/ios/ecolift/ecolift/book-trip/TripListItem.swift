import SwiftUI

struct TripListItem: View {
    var trip: Trip
    var body: some View {
        Text("Grid List Item")
    }
}

#Preview {
    var model = Model()
    var viwModel = ViewModel(model: model)
    ContentView(selectedTab: 0, viewModel: viwModel)
}
