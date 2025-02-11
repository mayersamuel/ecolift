import SwiftUI

struct TripDetail: View {
    var trip: Trip
    var body: some View {
        VStack {
            Text("from: \(trip.from)")
            Text("to: \(trip.to)")
            Text("time: \(trip.time)")
            Text("free seats: \(trip.seats)")
            Spacer()
        }
        .padding(.horizontal, 50)
        .padding(.top, 10)
    }
}

#Preview {
    var model = Model()
    var viwModel = ViewModel(model: model)
    ContentView(selectedTab: 0, viewModel: viwModel)
}
