import SwiftUI

struct RideListItem: View {
    var ride: EclRide
    var body: some View {
        Text("\(ride.time), seats: \(ride.seats), \(ride.notes)")
    }
}

#Preview {
    var model = Model()
    var viwModel = ViewModel(model: model)
    ContentView(selectedTab: 0, viewModel: viwModel)
}
